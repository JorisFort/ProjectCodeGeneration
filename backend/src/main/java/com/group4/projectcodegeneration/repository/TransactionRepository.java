package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
