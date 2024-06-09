package com.group4.projectcodegeneration.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String iban;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Account() {
        this.balance = 0.0;
    }

    private void checkTransferLimits(double amount) throws IllegalArgumentException {
        if (amount > customer.getDailyTransferLimit()) {
            throw new IllegalArgumentException("Transaction amount of " + amount + " exceeds daily transfer limit of " + customer.getDailyTransferLimit());
        }
        if (amount > customer.getAbsoluteTransferLimit()) {
            throw new IllegalArgumentException("Transaction amount of " + amount + " exceeds absolute transfer limit of " + customer.getAbsoluteTransferLimit());
        }
    }

    public void deposit(double amount) throws IllegalArgumentException {
        checkTransferLimits(amount);
        this.balance += amount;
        customer.addDailyTransferAmount(amount);
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        checkTransferLimits(amount);
        if (this.balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
        customer.addDailyTransferAmount(amount);
    }

    public void transfer(Account toAccount, double amount) throws IllegalArgumentException {
        checkTransferLimits(amount);
        withdraw(amount);
        toAccount.deposit(amount);
        customer.addDailyTransferAmount(amount);
    }
}