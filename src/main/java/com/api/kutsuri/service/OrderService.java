package com.api.kutsuri.service;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.Order;

public interface OrderService {
    Order add(Order order);
    List<Order> getAll();
    Optional<Order> getOrderById(int id);
    void deleteOrderById(int id);
    Order updateOrder(int id, Order orderDetails);
}
