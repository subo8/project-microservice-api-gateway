package com.mini2.springbootmicroservice3apigateway.controller;

import com.mini2.springbootmicroservice3apigateway.request.ProductServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/product")
public class ProductController {
    @Autowired
    private ProductServiceRequest productServiceRequest;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productServiceRequest.getProducts());
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Object product) {
        return new ResponseEntity<>(productServiceRequest.addProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId, @RequestBody Object payment) {
        productServiceRequest.deleteProduct(productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
