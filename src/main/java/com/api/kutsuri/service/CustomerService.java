package com.api.kutsuri.service;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.Customer;

public interface CustomerService {
    Customer add(Customer customer);
    List<Customer> getAll();
    Optional<Customer> getCustomerById(int id);
    void deleteCustomerById(int id);
    Customer updateCustomer(int id, Customer customerDetails);
}
