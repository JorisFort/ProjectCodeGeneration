package com.group4.projectcodegeneration.model.dto;

import com.group4.projectcodegeneration.model.TransactionType;

public record TransactionDto(String fromIban, String toIban, double amount,
                             TransactionType transactionType) {
}
