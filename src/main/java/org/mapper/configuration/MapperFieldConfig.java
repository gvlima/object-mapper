package org.mapper.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MapperFieldConfig {
    String sourceAttributeName() default "";
    boolean numericTypeConversion() default false;
}