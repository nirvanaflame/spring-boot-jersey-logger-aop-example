package com.nf.thestartap.spring.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j(topic = "trans.log")
@Aspect
@Component
public class TransactionLogInterceptor {

    private final Logger transaction;

    public TransactionLogInterceptor() {
        this.transaction = LoggerFactory.getLogger("transaction.log");
    }

    @Around("@annotation(com.nf.thestartap.spring.aspect.TransactionLog)")
    public Object logTransaction(ProceedingJoinPoint jointPoint) throws Throwable {
        log.info("logTransaction::enter");
        log.info("logTransaction::args=[{}]", jointPoint.getArgs());
        TransactionLog annotation = ((MethodSignature) jointPoint.getSignature()).getMethod().getAnnotation(TransactionLog.class);
        annotation.args();

        Object result = jointPoint.proceed();
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(result);
        transaction.info("logTransaction:: after proceed={}", json);

        return result;
    }
}
