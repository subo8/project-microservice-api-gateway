package com.mini2.springbootmicroservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Path;
import java.util.List;

@FeignClient(
        value = "shipment-service",
        path = "/api/shipment",
        configuration = FeignConfiguration.class
)
public interface ShipmentServiceRequest {

    @GetMapping
    List<Object> findAll();

    @PostMapping
    Object addShipment(@RequestBody Object requestBody);

    @PostMapping("{shipmentId}")
    Object updateShipment(@PathVariable("shipmentId") Long shipmentId, @RequestBody Object requestBody);
}
