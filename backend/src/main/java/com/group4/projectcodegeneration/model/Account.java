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
}