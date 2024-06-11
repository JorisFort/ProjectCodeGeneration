package com.group4.projectcodegeneration.model.dto;

import com.group4.projectcodegeneration.model.UserRole;

public record UserDto(Long id, String email, UserRole role) {
}
