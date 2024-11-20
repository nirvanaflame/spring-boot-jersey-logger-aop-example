package com.nf.thestartap.spring.dp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Transaction("trans-")
public class TransactionService implements Service {

    @Override
    public String getTransaction(String id) {
        Transaction annotation = TransactionService.class.getAnnotation(Transaction.class);
        String transaction = annotation.prefix() + id;
        log.info("transaction={}", transaction);
        return transaction;
    }
}
