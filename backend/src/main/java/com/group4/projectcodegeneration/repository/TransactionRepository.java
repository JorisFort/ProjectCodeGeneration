package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.model.Transaction;
import com.group4.projectcodegeneration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Iterable<Transaction> findByInitiatedBy(User user);
}
