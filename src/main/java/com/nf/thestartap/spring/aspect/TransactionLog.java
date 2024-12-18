package com.nf.thestartap.spring.aspect;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionLog {

    @AliasFor("serviceName")
    String value() default "";

    @AliasFor("value")
    String serviceName() default "";

    int[] exclude() default {};
}
