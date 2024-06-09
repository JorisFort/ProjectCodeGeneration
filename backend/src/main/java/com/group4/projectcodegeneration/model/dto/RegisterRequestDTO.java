package com.group4.projectcodegeneration.model.dto;

public record RegisterRequestDTO(String email, String password, String firstName, String lastName, String bsnNumber,
                                 String phoneNumber) {
}
