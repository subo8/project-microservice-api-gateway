package com.mini2.springbootmicroservice3apigateway.controller;

import com.mini2.springbootmicroservice3apigateway.request.PaymentServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceRequest paymentServiceRequest;

    @GetMapping
    public ResponseEntity<?> getAllPayments() {
        return ResponseEntity.ok(paymentServiceRequest.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addPayment(@RequestBody Object payment) {
        return new ResponseEntity<>(paymentServiceRequest.addPayment(payment), HttpStatus.CREATED);
    }

    @PostMapping("/pay/{paymentId}")
    public ResponseEntity<?> payPayment(@PathVariable("paymentId") Long paymentId, @RequestBody Object payment) {
        return new ResponseEntity<>(paymentServiceRequest.payPayment(paymentId, payment), HttpStatus.OK);
    }
}
