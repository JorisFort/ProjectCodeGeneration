package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.model.Transaction;
import com.group4.projectcodegeneration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByFromAccountInOrToAccountIn(List<Account> fromAccounts, List<Account> toAccounts);
}
