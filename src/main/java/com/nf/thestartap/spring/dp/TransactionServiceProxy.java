package com.nf.thestartap.spring.dp;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TransactionServiceProxy implements InvocationHandler {

    private Object target;

    public TransactionServiceProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("invoke proxy");
        return method.invoke(target, args);
    }
}
