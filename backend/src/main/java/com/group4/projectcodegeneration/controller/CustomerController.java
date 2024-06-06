package com.group4.projectcodegeneration.controller;

import com.group4.projectcodegeneration.model.Customer;
import com.group4.projectcodegeneration.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(201).body(createdCustomer);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).build());
    }

    @GetMapping("/unapproved")
    public ResponseEntity<Iterator<Customer>> getAllUnapprovedCustomers() {
        Iterator<Customer> customers = customerService.getAllUnapprovedCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{customerId}/approve")
    public ResponseEntity<Customer> approveCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.approveCustomer(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{customerId}/close")
    public ResponseEntity<Customer> closeCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.closeCustomer(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}

