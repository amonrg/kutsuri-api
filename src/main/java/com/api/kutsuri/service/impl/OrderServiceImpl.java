package com.api.kutsuri.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.Order;
import com.api.kutsuri.repository.OrderRepository;
import com.api.kutsuri.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {        
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(int id) {        
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow();        
        orderRepository.delete(order);
    }

    @Override
    public Order updateOrder(int id, Order orderDetails) {
        Order order = orderRepository.getById(id);

        order.setCustomer(orderDetails.getCustomer());
        order.setDate(orderDetails.getDate());
        order.setDue_payment(orderDetails.getDue_payment());
        order.setNotes(orderDetails.getNotes());
        order.setProduct(orderDetails.getProduct());
        order.setStatus(orderDetails.getStatus());

        return orderRepository.save(order);
    }
    
}
