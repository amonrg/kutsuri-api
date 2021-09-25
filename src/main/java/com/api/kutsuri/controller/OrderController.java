package com.api.kutsuri.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.kutsuri.model.Order;
import com.api.kutsuri.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping("/orders")
    public Order addOrder(@Valid @RequestBody Order order) {
        return orderService.add(order);
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable(name = "id") int id) {
        return orderService.getOrderById(id).orElseThrow();
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable(name = "id") int id, 
                             @Valid @RequestBody Order orderDetails) {
        return orderService.updateOrder(id, orderDetails);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(name = "id") int id) {        
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }
}
