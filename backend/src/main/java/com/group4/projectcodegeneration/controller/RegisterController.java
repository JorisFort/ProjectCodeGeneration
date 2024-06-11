package com.group4.projectcodegeneration.controller;

import com.group4.projectcodegeneration.model.dto.LoginResponseDto;
import com.group4.projectcodegeneration.model.dto.RegisterRequestDto;
import com.group4.projectcodegeneration.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final CustomerService customerService;

    public RegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDto> register(@RequestBody RegisterRequestDto registerRequestDTO) {
        return ResponseEntity.ok(customerService.register(registerRequestDTO));
    }
}
