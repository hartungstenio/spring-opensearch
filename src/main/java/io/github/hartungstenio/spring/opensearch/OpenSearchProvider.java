package io.github.hartungstenio.spring.opensearch;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.hartungstenio.spring.opensearch.model.SyndicationRights;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenSearchProvider {
    
    String shortName();
    String description();
    String contact();
    String tags();
    String longName();
    String developer();
    String attribution();
    SyndicationRights syndicationRight();
    boolean adultContent();
    String[] language();
    String[] inputEncoding();
    String[] outputEncoding();
}
