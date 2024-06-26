package com.group4.projectcodegeneration.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}