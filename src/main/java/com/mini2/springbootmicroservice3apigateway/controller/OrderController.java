package com.mini2.springbootmicroservice3apigateway.controller;

import com.mini2.springbootmicroservice3apigateway.request.OrderServiceRequest;
import com.mini2.springbootmicroservice3apigateway.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/order")
public class OrderController {
    @Autowired
    private OrderServiceRequest orderServiceRequest;

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody Object order) {
        return new ResponseEntity<>(orderServiceRequest.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllOrdersOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ResponseEntity.ok(orderServiceRequest.getAllOrderOfUser(userPrincipal.getId()));
    }
}
