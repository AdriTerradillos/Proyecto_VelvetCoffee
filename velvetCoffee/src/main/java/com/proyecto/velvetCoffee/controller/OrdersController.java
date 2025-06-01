package com.proyecto.velvetCoffee.controller;

import com.proyecto.velvetCoffee.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class OrdersController {

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        return ResponseEntity.ok(order);
    }
}
