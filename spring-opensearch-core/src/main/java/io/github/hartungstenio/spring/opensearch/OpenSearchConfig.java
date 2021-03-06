package io.github.hartungstenio.spring.opensearch;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.hartungstenio.spring.opensearch.model.OpenSearchDescription;

@Configuration
@ComponentScan
public class OpenSearchConfig {
    
    @Bean
    public OpenSearchDescription openSearchDescriptionDocument(final ApplicationContext app) {
        String[] appConfig = app.getBeanNamesForAnnotation(OpenSearchProvider.class);
        
        if(appConfig.length == 0) return null;
        
        OpenSearchProvider openSearchProvider = app.findAnnotationOnBean(appConfig[0], OpenSearchProvider.class);
        
        OpenSearchDescription.Builder openSearchDescriptionDocumentBuilder =
                new OpenSearchDescription.Builder(openSearchProvider.shortName(), openSearchProvider.description())
                    .tags(openSearchProvider.tags())
                    .longName(openSearchProvider.longName())
                    .developer(openSearchProvider.developer())
                    .attribution(openSearchProvider.attribution())
                    .syndicationRight(openSearchProvider.syndicationRight())
                    .adultContent(openSearchProvider.adultContent())
                    .languages(openSearchProvider.language())
                    .inputEncodings(openSearchProvider.inputEncoding())
                    .outputEncodings(openSearchProvider.outputEncoding());
        
        // Iterate Controllers to find every Url
        for(Object controller : app.getBeansWithAnnotation(Controller.class).values()) {
            findUrlsInControllerAndAppendToDocument(controller, openSearchDescriptionDocumentBuilder);
        }
        
        return openSearchDescriptionDocumentBuilder.build();
    }
    
    private void findUrlsInControllerAndAppendToDocument(Object controller, OpenSearchDescription.Builder documentBuilder) {
        for(Method method : controller.getClass().getMethods()) {
            if(method.isAnnotationPresent(OpenSearchResource.class)) {
                OpenSearchResource openSearchResource = method.getAnnotation(OpenSearchResource.class);
                
                StringBuilder urlTemplate = extractTemplateFromMethod(method).append("?");
                
                for(Parameter param : method.getParameters()) {
                    if(param.isAnnotationPresent(OpenSearchTemplateParameter.class)) {
                        findParametersAndAppendToUrl(param, urlTemplate);
                        urlTemplate.append('?');
                    }
                }
                
                urlTemplate.setLength(urlTemplate.length() - 1);
                documentBuilder.url(urlTemplate.toString(), openSearchResource.type());
            }
        }
    }
    
    private void findParametersAndAppendToUrl(Parameter parameter, StringBuilder urlTemplate) {
        OpenSearchTemplateParameter openSearchTemplateParameter = parameter.getAnnotation(OpenSearchTemplateParameter.class);
        urlTemplate.append(extractParameterName(parameter));
        urlTemplate.append('=').append('{').append(openSearchTemplateParameter.name()).append('}');
    }
    
    private String extractParameterName(Parameter parameter) {
        RequestParam requestParam = parameter.getAnnotation(RequestParam.class);
        
        if(requestParam != null && !StringUtils.isEmpty(requestParam.name())) {
            return requestParam.name();
        } else {
            MethodParameter methodParameter = MethodParameter.forParameter(parameter);
            methodParameter.initParameterNameDiscovery(new DefaultParameterNameDiscoverer());
            return methodParameter.getParameterName();
        }
    }
    
    private StringBuilder extractTemplateFromMethod(Method method) {
        StringBuilder sb = new StringBuilder();
        
        // Find RequestMapping in controller;
        RequestMapping controllerMapping = method.getDeclaringClass().getAnnotation(RequestMapping.class);
        if(controllerMapping != null) {
            String[] value = controllerMapping.value();
            if(value.length > 0) {
                sb.append(value[0]);
            }
        }
        
        // RequestMapping in method
        RequestMapping methodMapping = method.getAnnotation(RequestMapping.class);
        if(methodMapping != null) {
            String[] value = methodMapping.value();
            if(value.length > 0) {
                sb.append(value[0]);
            }
        }
        
        return sb;
    }
}
