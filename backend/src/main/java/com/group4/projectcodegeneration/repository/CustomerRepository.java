package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByAccountApprovedFalse();
}
