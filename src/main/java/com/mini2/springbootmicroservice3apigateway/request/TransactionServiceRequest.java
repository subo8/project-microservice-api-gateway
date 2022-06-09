package com.mini2.springbootmicroservice3apigateway.request;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(value = "transaction-service", path = "/transaction", configuration = FeignConfiguration.class)
public interface TransactionServiceRequest {

    @GetMapping
    List<Object> getAllTransactions();

    @PostMapping("add")
    Object addTransaction(@RequestBody Object requestBody);
}