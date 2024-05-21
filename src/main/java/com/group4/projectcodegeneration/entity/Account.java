package com.group4.projectcodegeneration.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
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
}