package io.github.hartungstenio.spring.opensearch;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.PARAMETER)
public @interface OpenSearchTemplateParameter {
    String name() default "searchTerms";
}
