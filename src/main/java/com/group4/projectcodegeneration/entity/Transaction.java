package com.group4.projectcodegeneration.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "fromAccountId")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "toAccountId")
    private Account toAccount;

    private Double amount;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "initiatedBy")
    private User initiatedBy;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}

