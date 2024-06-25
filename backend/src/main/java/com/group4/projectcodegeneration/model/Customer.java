package com.group4.projectcodegeneration.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    private String firstName;
    private String lastName;
    private String bsnNumber;
    private String phoneNumber;
    private Boolean accountApproved;
    private Double dailyTransferLimit;
    private Double dailyTransferAmount;
    private Double absoluteTransferLimit;

    public Customer() {
        this.dailyTransferLimit = 10000.0;
        this.dailyTransferAmount = 0.0;
        this.absoluteTransferLimit = 100000.0;
    }

    public void addDailyTransferAmount(double amount) {
        this.dailyTransferAmount += amount;
    }
}