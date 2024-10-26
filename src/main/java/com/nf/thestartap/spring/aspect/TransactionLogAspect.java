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

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

@Slf4j
@Aspect
@Component
public class TransactionLogAspect {

    private final Logger transaction = LoggerFactory.getLogger("transaction.log");

    @Around("@annotation(com.nf.thestartap.spring.aspect.TransactionLog)")
    public Object logTransaction(ProceedingJoinPoint jointPoint) throws Throwable {
        log.info("logTransaction::enter");

        TransactionLog annotation = ((MethodSignature) jointPoint.getSignature()).getMethod().getAnnotation(TransactionLog.class);
        var logArg = getArgsToLog(jointPoint.getArgs(), annotation.exclude());

        log.info("logTransaction::args=[{}]", logArg);

        Object result = jointPoint.proceed();
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(result);
        transaction.info("logTransaction:: after proceed={}", json);

        return result;
    }

    private static Object[] getArgsToLog(Object[] args, int[] exclude) {
        return exclude.length == 0
                ? args
                : IntStream.range(0, args.length)
                .filter(i -> Arrays.stream(exclude).noneMatch(it -> it == i))
                .mapToObj(i -> args[i])
                .toArray();
    }
}
