package io.github.hartungstenio.spring.opensearch.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.hartungstenio.spring.opensearch.model.OpenSearchDescription;

@Configuration
@ConditionalOnClass(OpenSearchDescription.class)
@EnableConfigurationProperties(OpenSearchProperties.class)
public class OpenSearchAutoConfiguration {
    
    @Autowired
    private OpenSearchProperties openSearchProperties;
    
    @Bean
    @ConditionalOnMissingBean
    public OpenSearchDescription openSearchDescription() {
        OpenSearchDescription.Builder openSearchDescriptionDocumentBuilder =
                new OpenSearchDescription.Builder(openSearchProperties.getShortName(), openSearchProperties.getDescription())
                    .tags(openSearchProperties.getTags())
                    .longName(openSearchProperties.getLongName())
                    .developer(openSearchProperties.getDeveloper())
                    .attribution(openSearchProperties.getAttribution())
                    .syndicationRight(openSearchProperties.getSyndicationRight())
                    .adultContent(openSearchProperties.isAdultContent())
                    .languages(openSearchProperties.getLanguage())
                    .inputEncodings(openSearchProperties.getInputEncoding())
                    .outputEncodings(openSearchProperties.getOutputEncoding());

        return openSearchDescriptionDocumentBuilder.build();
    }
}
