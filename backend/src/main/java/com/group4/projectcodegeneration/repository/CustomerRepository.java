package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Iterator<Customer> findByAccountApprovedFalse();
}
