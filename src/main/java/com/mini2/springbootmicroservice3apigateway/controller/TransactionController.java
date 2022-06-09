package com.mini2.springbootmicroservice3apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini2.springbootmicroservice3apigateway.request.TransactionServiceRequest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("gateway/transaction")
public class TransactionController {
    @Autowired
    private TransactionServiceRequest transactionServiceRequest;

    @PostMapping("/add")
    public ResponseEntity<?> addTransaction(@RequestBody Object transaction) {
        return new ResponseEntity<>(transactionServiceRequest.addTransaction(transaction), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactions() {
        return ResponseEntity.ok(transactionServiceRequest.getAllTransactions());
    }
}
