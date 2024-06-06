package com.group4.projectcodegeneration.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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

