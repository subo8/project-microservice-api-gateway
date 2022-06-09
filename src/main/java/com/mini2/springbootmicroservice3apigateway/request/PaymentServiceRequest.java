package com.mini2.springbootmicroservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        value = "payment-service",
        path = "/api/payment",
        configuration = FeignConfiguration.class
)
public interface PaymentServiceRequest {
    @GetMapping
    List<Object> findAll();

    @PostMapping
    Object addPayment(@RequestBody Object requestBody);

    @PostMapping("/pay/{paymentId}")
    Object payPayment(@PathVariable("paymentId") Long paymentId, @RequestBody Object requestBody);

}
