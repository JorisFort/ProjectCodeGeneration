package com.group4.projectcodegeneration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group4.projectcodegeneration.configuration.ApiTestConfiguration;
import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.model.UserRole;
import com.group4.projectcodegeneration.model.dto.LoginRequestDto;
import com.group4.projectcodegeneration.model.dto.LoginResponseDto;
import com.group4.projectcodegeneration.model.dto.UserDto;
import com.group4.projectcodegeneration.security.JwtProvider;
import com.group4.projectcodegeneration.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.naming.AuthenticationException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LoginController.class)
@AutoConfigureMockMvc(addFilters = false)
@Import(ApiTestConfiguration.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;

    @BeforeEach
    void init() {
        user = new User();
        user.setEmail("email@email.com");
        user.setPassword("password");
        user.setRole(UserRole.ROLE_EMPLOYEE);
        user.setId(1L);
    }

    @Test
    void loginWithValidCredentialsShouldReturn200AndLoginResponseDto() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto(user.getEmail(), user.getPassword());
        LoginResponseDto loginResponseDto = new LoginResponseDto(new UserDto(user.getId(), user.getEmail(), user.getRole()), "token");

        when(userService.login(any(LoginRequestDto.class))).thenReturn(loginResponseDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(new ObjectMapper().writeValueAsString(loginRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.id").value(user.getId()))
                .andExpect(jsonPath("$.user.email").value(user.getEmail()))
                .andExpect(jsonPath("$.user.role").value(user.getRole().getAuthority()))
                .andExpect(jsonPath("$.token").value("token"));
    }

    @Test
    void loginWithInvalidCredentialsShouldReturn401() throws Exception {
        LoginRequestDto loginRequestDto = new LoginRequestDto(user.getEmail(), "wrongpassword");

        when(userService.login(any(LoginRequestDto.class))).thenThrow(AuthenticationException.class);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/login")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(new ObjectMapper().writeValueAsString(loginRequestDto)))
                .andExpect(status().isUnauthorized());
    }
}
