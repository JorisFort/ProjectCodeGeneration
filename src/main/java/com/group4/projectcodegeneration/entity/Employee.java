package com.group4.projectcodegeneration.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}

