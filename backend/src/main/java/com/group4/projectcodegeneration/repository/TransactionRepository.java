package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
