package com.group4.projectcodegeneration.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_CUSTOMER,
    ROLE_EMPLOYEE;

    @Override
    public String getAuthority() {
        return name();
    }
}
