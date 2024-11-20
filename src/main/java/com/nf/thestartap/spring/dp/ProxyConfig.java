package com.nf.thestartap.spring.dp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class ProxyConfig {

    @Bean
    Object transactionServiceProxy(TransactionService service) {
        return Proxy.newProxyInstance(
                getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new TransactionServiceProxy(service)
        );
    }
}
