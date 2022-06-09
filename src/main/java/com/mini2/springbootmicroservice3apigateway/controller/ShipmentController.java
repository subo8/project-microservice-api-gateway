package com.mini2.springbootmicroservice3apigateway.controller;

import com.mini2.springbootmicroservice3apigateway.request.ShipmentServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentServiceRequest shipmentServiceRequest;

    @GetMapping
    public ResponseEntity<?> getAllShipments() {
        return ResponseEntity.ok(shipmentServiceRequest.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addShipment(@RequestBody Object shipment) {
        return new ResponseEntity<>(shipmentServiceRequest.addShipment(shipment), HttpStatus.CREATED);
    }

    @PostMapping("{shipmentId}")
    public ResponseEntity<?> updateShipment(@PathVariable("shipmentId") Long shipmentId, @RequestBody Object shipment) {
        return new ResponseEntity<>(shipmentServiceRequest.updateShipment(shipmentId, shipment), HttpStatus.OK);
    }
}
