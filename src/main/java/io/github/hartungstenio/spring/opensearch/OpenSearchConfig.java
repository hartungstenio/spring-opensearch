package io.github.hartungstenio.spring.opensearch;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.hartungstenio.spring.opensearch.model.OpenSearchDescription;
import io.github.hartungstenio.spring.opensearch.model.OpenSearchDescriptionDocumentBuilder;

@Configuration
public class OpenSearchConfig {
    
    @Bean
    public OpenSearchDescription openSearchDescriptionDocument(final ApplicationContext app) {
        String[] appConfig = app.getBeanNamesForAnnotation(OpenSearchProvider.class);
        
        if(appConfig.length == 0) return null;
        
        OpenSearchProvider openSearchProvider = app.findAnnotationOnBean(appConfig[0], OpenSearchProvider.class);
        
        OpenSearchDescriptionDocumentBuilder openSearchDescriptionDocumentBuilder = new OpenSearchDescriptionDocumentBuilder(openSearchProvider.shortName(), openSearchProvider.description());
        openSearchDescriptionDocumentBuilder.setTags(openSearchProvider.tags());
        openSearchDescriptionDocumentBuilder.setLongName(openSearchProvider.longName());
        openSearchDescriptionDocumentBuilder.setDeveloper(openSearchProvider.developer());
        openSearchDescriptionDocumentBuilder.setAttribution(openSearchProvider.attribution());
        openSearchDescriptionDocumentBuilder.setSyndicationRight(openSearchProvider.syndicationRight());
        openSearchDescriptionDocumentBuilder.setAdultContent(openSearchProvider.adultContent());
        openSearchDescriptionDocumentBuilder.setLanguage(Arrays.asList(openSearchProvider.language()));
        openSearchDescriptionDocumentBuilder.setInputEncoding(Arrays.asList(openSearchProvider.inputEncoding()));
        openSearchDescriptionDocumentBuilder.setOutputEncoding(Arrays.asList(openSearchProvider.outputEncoding()));
        
        // Iterate Controllers to find every Url
        for(Object controller : app.getBeansWithAnnotation(Controller.class).values()) {
            findUrlsInControllerAndAppendToDocument(controller, openSearchDescriptionDocumentBuilder);
        }
        
        return openSearchDescriptionDocumentBuilder.build();
    }
    
    private void findUrlsInControllerAndAppendToDocument(Object controller, OpenSearchDescriptionDocumentBuilder documentBuilder) {
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
                documentBuilder.withUrl(urlTemplate.toString(), openSearchResource.type());
            }
        }
    }
    
    private void findParametersAndAppendToUrl(Parameter parameter, StringBuilder urlTemplate) {
        MethodParameter methodParameter = MethodParameter.forParameter(parameter);
        
        OpenSearchTemplateParameter openSearchTemplateParameter = methodParameter.getMethodAnnotation(OpenSearchTemplateParameter.class);
        RequestParam requestParam = methodParameter.getMethodAnnotation(RequestParam.class);
        
        if(requestParam != null && !StringUtils.isEmpty(requestParam.name())) {
            urlTemplate.append(requestParam.name());
        } else {
            methodParameter.initParameterNameDiscovery(new DefaultParameterNameDiscoverer());
            urlTemplate.append(methodParameter.getParameterName());
        }
        
        urlTemplate.append('=').append('{').append(openSearchTemplateParameter.name()).append('}');
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
        if(controllerMapping != null) {
            String[] value = methodMapping.value();
            if(value.length > 0) {
                sb.append(value[0]);
            }
        }
        
        return sb;
    }
}
