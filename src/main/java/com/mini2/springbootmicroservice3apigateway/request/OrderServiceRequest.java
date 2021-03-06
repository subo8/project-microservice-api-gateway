package com.mini2.springbootmicroservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "order-service", // microservice-application-name
                path = "/order", // pre-path for service endpoints
                configuration = FeignConfiguration.class)

public interface OrderServiceRequest {
        @PostMapping("add")
        Object placeOrder();

//        @GetMapping("{userId}")
//        List<Object> getAllOrderOfUser(@PathVariable("userId") Long userId);

        @GetMapping
        List<Object> listOrders();

        @GetMapping("{id}")
        Object getOrderById(@PathVariable("id") Integer orderId);

}
