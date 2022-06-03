package com.mini2.springbootmicroservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        value = "product-service",
        path="/api/product",
//        url="${product.service.url}",
        configuration = FeignConfiguration.class
)
public interface ProductServiceRequest {
    @PostMapping
    Object saveProduct(@RequestBody Object requestBody);

    @DeleteMapping("{productId}")
    void deleteProduct(@PathVariable("productId") Long productId);

    @GetMapping
    List<Object> getAllProducts();
}
