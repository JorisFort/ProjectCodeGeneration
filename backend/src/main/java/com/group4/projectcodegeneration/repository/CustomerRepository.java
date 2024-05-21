package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
