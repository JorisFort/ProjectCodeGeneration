package com.group4.projectcodegeneration.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
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