package com.order.service;



import com.order.model.OrderData;
import com.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Create or Update Order
    public OrderData saveOrder(OrderData order) {
        return orderRepository.save(order);
    }

    // Get all Orders
    public List<OrderData> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order by ID
    public Optional<OrderData> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Delete Order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

