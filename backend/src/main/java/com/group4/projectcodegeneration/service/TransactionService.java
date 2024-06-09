package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.model.Transaction;
import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.model.dto.TransactionDTO;
import com.group4.projectcodegeneration.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Transaction createTransaction(TransactionDTO transaction) throws IllegalArgumentException {
        User user = userService.getAuthenticatedUser();

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

    private void handleDeposit(TransactionDTO transaction, Transaction newTransaction) throws IllegalArgumentException {
        Account account = getAccountByIban(transaction.toIban());
        account.deposit(transaction.amount());
        newTransaction.setToAccount(account);

        // Update account balance
        accountService.updateAccount(account);
    }

    private void handleWithdrawal(TransactionDTO transaction, Transaction newTransaction) throws IllegalArgumentException {
        Account account = getAccountByIban(transaction.fromIban());
        account.withdraw(transaction.amount());
        newTransaction.setFromAccount(account);

        // Update account balance
        accountService.updateAccount(account);
    }

    private void handleTransfer(TransactionDTO transaction, Transaction newTransaction) throws IllegalArgumentException {
        Account fromAccount = getAccountByIban(transaction.fromIban());
        Account toAccount = getAccountByIban(transaction.toIban());

        fromAccount.transfer(toAccount, transaction.amount());

        newTransaction.setFromAccount(fromAccount);
        newTransaction.setToAccount(toAccount);

        // Update account balances
        accountService.updateAccount(fromAccount);
        accountService.updateAccount(toAccount);
    }

    private Account getAccountByIban(String iban) throws IllegalArgumentException {
        Optional<Account> account = accountService.getAccountByIban(iban);
        if (account.isEmpty()) throw new IllegalArgumentException("Account for IBAN " + iban + " not found");
        return account.get();
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findByInitiatedBy(user);
    }

    public Optional<Transaction> getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }
}

