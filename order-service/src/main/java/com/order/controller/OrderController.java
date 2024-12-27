package com.order.controller;


import com.order.model.OrderData;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get all orders
    @GetMapping
    public List<OrderData> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderData> getOrderById(@PathVariable Long id) {
        Optional<OrderData> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new order
    @PostMapping
    public ResponseEntity<OrderData> createOrder(@RequestBody OrderData order) {
        OrderData savedOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<OrderData> updateOrder(@PathVariable Long id, @RequestBody OrderData order) {
        Optional<OrderData> existingOrder = orderService.getOrderById(id);
        if (existingOrder.isPresent()) {
            order.setId(id);
            OrderData updatedOrder = orderService.saveOrder(order);
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

