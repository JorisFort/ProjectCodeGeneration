package com.group4.projectcodegeneration.controller;

import com.group4.projectcodegeneration.configuration.ApiTestConfiguration;
import com.group4.projectcodegeneration.model.*;
import com.group4.projectcodegeneration.security.JwtProvider;
import com.group4.projectcodegeneration.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
@Import(ApiTestConfiguration.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    private Account account;

    @BeforeEach
    void init() {
        account = new Account();
        account.setAccountId(1L);
        account.setBalance(100.0);
        account.setAccountType(AccountType.CHECKING);
        account.setIban("DE89370400440532013000");
    }

    @Test
    @WithMockUser(roles = "EMPLOYEE")
    void getAccountByIdShouldReturn200AndAccount() throws Exception {
        when(accountService.getAccountById(anyLong())).thenReturn(Optional.of(account));

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountId").value(account.getAccountId()))
                .andExpect(jsonPath("$.balance").value(account.getBalance()))
                .andExpect(jsonPath("$.accountType").value(account.getAccountType().toString()))
                .andExpect(jsonPath("$.iban").value(account.getIban()));
    }

    @Test
    @WithMockUser(roles = "EMPLOYEE")
    void getAllAccountsShouldReturn200AndListOfAccounts() throws Exception {
        List<Account> accounts = Collections.singletonList(account);
        when(accountService.getAllAccounts()).thenReturn(accounts);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].accountId").value(account.getAccountId()))
                .andExpect(jsonPath("$[0].balance").value(account.getBalance()))
                .andExpect(jsonPath("$[0].accountType").value(account.getAccountType().toString()))
                .andExpect(jsonPath("$[0].iban").value(account.getIban()));
    }

    @Test
    @WithMockUser(roles = "EMPLOYEE")
    void getAllCustomerAccountsShouldReturn200AndListOfAccounts() throws Exception {
        List<Account> accounts = Collections.singletonList(account);
        when(accountService.getAllCustomerAccounts(anyLong())).thenReturn(accounts);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/customer/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].accountId").value(account.getAccountId()))
                .andExpect(jsonPath("$[0].balance").value(account.getBalance()))
                .andExpect(jsonPath("$[0].accountType").value(account.getAccountType().toString()))
                .andExpect(jsonPath("$[0].iban").value(account.getIban()));
    }
}