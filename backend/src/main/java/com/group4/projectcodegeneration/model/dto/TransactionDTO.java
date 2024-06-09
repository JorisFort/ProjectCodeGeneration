package com.group4.projectcodegeneration.model.dto;

import com.group4.projectcodegeneration.model.TransactionType;

public record TransactionDTO(String fromIban, String toIban, double amount,
                             TransactionType transactionType) {
}
