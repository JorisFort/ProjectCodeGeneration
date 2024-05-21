package com.group4.projectcodegeneration.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    private String firstName;
    private String lastName;
    private String bsnNumber;
    private String phoneNumber;
    private Boolean accountApproved;
    private Double dailyTransferLimit;
    private Double absoluteTransferLimit;
}