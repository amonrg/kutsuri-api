package com.api.kutsuri.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.kutsuri.exception.ItemNotFoundException;
import com.api.kutsuri.model.Customer;
import com.api.kutsuri.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @PostMapping("/customers")
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return customerService.add(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") int id) {
        return customerService.getCustomerById(id).orElseThrow(() -> new ItemNotFoundException(id, "customer"));
    }
    
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") int id, 
                                   @Valid @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(id, customerDetails);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") int id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }
}
