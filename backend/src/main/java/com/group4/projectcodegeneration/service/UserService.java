package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.model.dto.LoginRequestDto;
import com.group4.projectcodegeneration.model.dto.LoginResponseDto;
import com.group4.projectcodegeneration.model.dto.UserDto;
import com.group4.projectcodegeneration.repository.UserRepository;
import com.group4.projectcodegeneration.security.JwtProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
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

    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email is already in use");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public LoginResponseDto login(LoginRequestDto loginRequest) throws AuthenticationException {
        Optional<User> user = userRepository.findByEmail(loginRequest.email());
        if (user.isPresent() && passwordEncoder.matches(loginRequest.password(), user.get().getPassword())) {
            return new LoginResponseDto(new UserDto(user.get().getId(), user.get().getEmail(), user.get().getRole()), jwtProvider.createToken(user.get()));
        } else {
            throw new AuthenticationException("Invalid credentials");
        }
    }

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        return getUserByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}

