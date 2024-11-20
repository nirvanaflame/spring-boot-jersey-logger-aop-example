package com.nf.thestartap.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class TransactionLogAspect {

    private final Logger transaction = LoggerFactory.getLogger("transaction.log");

    @Around("@annotation(com.nf.thestartap.spring.aspect.TransactionLog)")
    public Object logTransaction(ProceedingJoinPoint jointPoint) throws Throwable {
        log.info("logTransaction::enter");

        Method method = ((MethodSignature) jointPoint.getSignature()).getMethod();
        TransactionLog annotation = method.getAnnotation(TransactionLog.class);

        // Access the values
        String value = annotation.value();
        String serviceName = annotation.serviceName();

        log.info("logTransaction:: annotation value={}, serviceName={}", value, serviceName);

        return jointPoint.proceed();
    }
}
