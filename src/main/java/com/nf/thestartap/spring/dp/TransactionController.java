package com.nf.thestartap.spring.dp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/trans")
public class TransactionController {

    @Autowired
    Service service;

    @GetMapping("/{id}")
    String getTransaction(String id) {
        return service.getTransaction(id);
    }
}
