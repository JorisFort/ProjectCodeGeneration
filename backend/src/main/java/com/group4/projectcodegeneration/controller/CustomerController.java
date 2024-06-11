package com.group4.projectcodegeneration.controller;

import com.group4.projectcodegeneration.model.Customer;
import com.group4.projectcodegeneration.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/unapproved")
    public ResponseEntity<List<Customer>> getAllUnapprovedCustomers() {
        List<Customer> customers = customerService.getAllUnapprovedCustomers();
        return ResponseEntity.ok(customers);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @PutMapping("/{userId}/approve")
    public ResponseEntity<Customer> approveCustomer(@PathVariable Long userId) {
        Customer customer = customerService.approveCustomer(userId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
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

