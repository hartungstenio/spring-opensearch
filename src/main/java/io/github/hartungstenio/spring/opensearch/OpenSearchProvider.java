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
    String contact() default "";
    String tags() default "";
    String longName() default "";
    String developer() default "";
    String attribution() default "";
    SyndicationRights syndicationRight() default SyndicationRights.OPEN;
    boolean adultContent() default false;
    String[] language() default {};
    String[] inputEncoding() default {};
    String[] outputEncoding() default {};
}
