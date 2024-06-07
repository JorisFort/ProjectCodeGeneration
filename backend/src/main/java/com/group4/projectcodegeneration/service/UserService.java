package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.model.dto.LoginRequestDto;
import com.group4.projectcodegeneration.model.dto.LoginResponseDto;
import com.group4.projectcodegeneration.repository.UserRepository;
import com.group4.projectcodegeneration.security.JwtProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public User createUser(User user) throws IllegalArgumentException {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("Email is already in use");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public LoginResponseDto login(LoginRequestDto loginRequest) throws AuthenticationException {
        User user = userRepository.findByEmail(loginRequest.email());
        if (user != null && passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            return new LoginResponseDto(user.getEmail(), jwtProvider.createToken(user));
        } else {
            throw new AuthenticationException("Invalid credentials");
        }
    }
}

