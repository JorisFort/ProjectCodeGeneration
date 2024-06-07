package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.Transaction;
import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Iterable<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findByInitiatedBy(user);
    }

    public Optional<Transaction> getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }
}

