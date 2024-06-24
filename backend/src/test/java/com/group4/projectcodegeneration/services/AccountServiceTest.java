package com.group4.projectcodegeneration.services;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.model.AccountType;
import com.group4.projectcodegeneration.model.Customer;
import com.group4.projectcodegeneration.repository.AccountRepository;
import com.group4.projectcodegeneration.repository.CustomerRepository;
import com.group4.projectcodegeneration.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private CustomerRepository customerRepository;

    private Account account;
    private Customer customer;

    @BeforeEach
    public void init() {
        account = new Account();
        account.setAccountId(1L);
        account.setBalance(100.0);
        account.setAccountType(AccountType.CHECKING);
        account.setIban("DE89370400440532013000");

        customer = new Customer();
        customer.setUserId(1L);
        account.setCustomer(customer);
    }

    @Test
    public void testCreateAccount() {
        when(accountRepository.save(any(Account.class))).thenReturn(account);
        Account created = accountService.createAccount(account);
        assertEquals(account, created);
    }

    @Test
    public void testUpdateAccount() {
        when(accountRepository.save(account)).thenReturn(account);
        Account updated = accountService.updateAccount(account);
        assertEquals(account, updated);
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    public void testGetAllAccounts() {
        when(accountRepository.findAll()).thenReturn(Collections.singletonList(account));
        List<Account> accounts = accountService.getAllAccounts();
        assertEquals(1, accounts.size());
        assertEquals(account, accounts.get(0));
    }

    @Test
    public void testGetAllCustomerAccounts() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
        when(accountRepository.findByCustomer(any(Customer.class))).thenReturn(Collections.singletonList(account));
        List<Account> accounts = accountService.getAllCustomerAccounts(1L);
        assertEquals(1, accounts.size());
        assertEquals(account, accounts.get(0));
    }

    @Test
    public void testGetAccountByIban() {
        when(accountRepository.findByIban(anyString())).thenReturn(Optional.of(account));
        Optional<Account> foundAccount = accountService.getAccountByIban("DE89370400440532013000");
        assertTrue(foundAccount.isPresent());
        assertEquals(account, foundAccount.get());
    }

    @Test
    public void testGetAccountById() {
        when(accountRepository.findById(anyLong())).thenReturn(Optional.of(account));
        Optional<Account> foundAccount = accountService.getAccountById(1L);
        assertTrue(foundAccount.isPresent());
        assertEquals(account, foundAccount.get());
    }
}