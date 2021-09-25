package com.api.kutsuri.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.Customer;
import com.api.kutsuri.repository.CustomerRepository;
import com.api.kutsuri.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);
    }

    @Override
    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer customer = customerRepository.getById(id);

        customer.setAddress(customerDetails.getAddress());
        customer.setAlias(customerDetails.getAlias());
        customer.setEmail(customerDetails.getEmail());
        customer.setLast_name(customerDetails.getLast_name());
        customer.setName(customerDetails.getName());
        customer.setPhone_number(customerDetails.getPhone_number());

        return customerRepository.save(customer);
    }
}
