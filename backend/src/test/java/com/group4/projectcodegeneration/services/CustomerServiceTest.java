package com.group4.projectcodegeneration.services;

import com.group4.projectcodegeneration.model.*;
import com.group4.projectcodegeneration.repository.CustomerRepository;
import com.group4.projectcodegeneration.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    public void init() {
        User user = new User();
        user.setId(1L);
        user.setEmail("email@email.com");
        user.setPassword("password");
        user.setRole(UserRole.ROLE_CUSTOMER);

        customer = new Customer();
        customer.setUserId(1L);
        customer.setUser(user);
    }

    @Test
    public void testUpdateCustomer() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        customerService.updateCustomer(customer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    @WithMockUser(username = "employee@bank.nl")
    public void testGetCustomerById() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
        Optional<Customer> foundCustomer = customerService.getCustomerById(1L);
        assertTrue(foundCustomer.isPresent());
        assertEquals(customer, foundCustomer.get());
    }

    @Test
    @WithMockUser(username = "customer@customer.nl")
    public void testGetCustomerByIdWithDifferentUser() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        Exception exception = assertThrows(InsufficientAuthenticationException.class, () -> customerService.getCustomerById(1L));

        String expectedMessage = "You are not authorized to view this customer";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetAllUnapprovedCustomers() {
        when(customerRepository.findByAccountApprovedFalse()).thenReturn(Collections.singletonList(customer));
        List<Customer> customers = customerService.getAllUnapprovedCustomers();
        assertEquals(1, customers.size());
        assertEquals(customer, customers.get(0));
    }
}
