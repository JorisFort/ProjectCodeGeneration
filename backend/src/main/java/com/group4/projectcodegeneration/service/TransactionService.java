package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.model.Transaction;
import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.model.UserRole;
import com.group4.projectcodegeneration.model.dto.TransactionDto;
import com.group4.projectcodegeneration.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final AccountService accountService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
        this.accountService = accountService;
    }

    public Transaction createTransaction(TransactionDto transaction, User user) {
        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.amount());
        newTransaction.setInitiatedBy(user);
        newTransaction.setTransactionType(transaction.transactionType());

        switch (transaction.transactionType()) {
            case DEPOSIT -> handleDeposit(transaction, newTransaction);
            case WITHDRAWAL -> handleWithdrawal(transaction, newTransaction);
            case TRANSFER -> handleTransfer(transaction, newTransaction);
            default -> throw new IllegalArgumentException("Invalid transaction type");
        }

        return transactionRepository.save(newTransaction);
    }

    private void handleDeposit(TransactionDto transaction, Transaction newTransaction){
        Account account = getAccountByIban(transaction.toIban());
        account.deposit(transaction.amount());
        newTransaction.setToAccount(account);

        // Update account balance
        accountService.updateAccount(account);
    }

    private void handleWithdrawal(TransactionDto transaction, Transaction newTransaction){
        Account account = getAccountByIban(transaction.fromIban());
        account.withdraw(transaction.amount());
        newTransaction.setFromAccount(account);

        // Update account balance
        accountService.updateAccount(account);
    }

    private void handleTransfer(TransactionDto transaction, Transaction newTransaction) {
        Account fromAccount = getAccountByIban(transaction.fromIban());
        Account toAccount = getAccountByIban(transaction.toIban());

        fromAccount.transfer(toAccount, transaction.amount());

        newTransaction.setFromAccount(fromAccount);
        newTransaction.setToAccount(toAccount);

        // Update account balances
        accountService.updateAccount(fromAccount);
        accountService.updateAccount(toAccount);
    }

    private Account getAccountByIban(String iban) {
        return accountService.getAccountByIban(iban).orElseThrow(() -> new EntityNotFoundException("Account for IBAN " + iban + " not found"));
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByUser(User user) {
        User authenticatedUser = userService.getAuthenticatedUser();

        // Only the user themselves or an employee can view the transactions of a user
        if (authenticatedUser.getRole() == UserRole.ROLE_CUSTOMER && !user.equals(userService.getAuthenticatedUser()))
            throw new InsufficientAuthenticationException("You are not authorized to view this user's transactions.");

        List<Account> accounts = accountService.getAllCustomerAccounts(user.getId());

        return transactionRepository.findByFromAccountInOrToAccountIn(accounts, accounts);
    }

    public List<Transaction> getTransactionsByAccount(Long accountId) {
        Account account = accountService.getAccountById(accountId).orElseThrow(() -> new EntityNotFoundException("Account with ID " + accountId + " not found"));
        User authenticatedUser = userService.getAuthenticatedUser();

        // Only the user themselves or an employee can view the transactions of a user
        if (authenticatedUser.getRole() == UserRole.ROLE_CUSTOMER && !account.getCustomer().getUserId().equals(authenticatedUser.getId()))
            throw new InsufficientAuthenticationException("You are not authorized to view this user's transactions.");


        return transactionRepository.findByFromAccountInOrToAccountIn(Collections.singletonList(account), Collections.singletonList(account));
    }
}

