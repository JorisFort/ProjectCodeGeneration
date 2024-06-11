package com.group4.projectcodegeneration.controller;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.model.Customer;
import com.group4.projectcodegeneration.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/customer/{userId}")
    public ResponseEntity<List<Account>> getAllCustomerAccounts(@PathVariable Long userId) {
        return ResponseEntity.ok(accountService.getAllCustomerAccounts(userId));
    }
}

