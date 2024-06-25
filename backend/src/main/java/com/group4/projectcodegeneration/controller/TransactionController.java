package com.group4.projectcodegeneration.controller;

import com.group4.projectcodegeneration.model.Transaction;
import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.model.dto.TransactionDto;
import com.group4.projectcodegeneration.service.TransactionService;
import com.group4.projectcodegeneration.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto transaction) {
        User user = userService.getAuthenticatedUser();
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(transaction, user));
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getAllTransactionsByUser(@PathVariable Long userId) {
        return userService.getUserById(userId).map(user -> ResponseEntity.ok(transactionService.getTransactionsByUser(user))).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getAllTransactionsByAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccount(accountId));
    }
}

