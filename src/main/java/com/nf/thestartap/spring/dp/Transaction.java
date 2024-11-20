package com.nf.thestartap.spring.dp;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction {

    @AliasFor("prefix")
    String value() default "";

    @AliasFor("value")
    String prefix() default "";
}
