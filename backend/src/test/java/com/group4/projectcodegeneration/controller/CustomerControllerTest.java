package com.group4.projectcodegeneration.controller;

import com.group4.projectcodegeneration.configuration.ApiTestConfiguration;
import com.group4.projectcodegeneration.model.Customer;
import com.group4.projectcodegeneration.service.CustomerService;
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
@WebMvcTest(CustomerController.class)
@Import(ApiTestConfiguration.class)
@AutoConfigureMockMvc(addFilters = false)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void init() {
        customer = new Customer();
        customer.setUserId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setBsnNumber("123456789");
        customer.setPhoneNumber("1234567890");
        customer.setAccountApproved(true);
        customer.setDailyTransferLimit(10000.0);
        customer.setAbsoluteTransferLimit(10000.0);
    }

    @Test
    @WithMockUser(roles = "EMPLOYEE")
    void getCustomerByIdShouldReturn200AndCustomer() throws Exception {
        when(customerService.getCustomerById(anyLong())).thenReturn(Optional.of(customer));

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(customer.getUserId()))
                .andExpect(jsonPath("$.firstName").value(customer.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(customer.getLastName()))
                .andExpect(jsonPath("$.bsnNumber").value(customer.getBsnNumber()))
                .andExpect(jsonPath("$.phoneNumber").value(customer.getPhoneNumber()))
                .andExpect(jsonPath("$.accountApproved").value(customer.getAccountApproved()))
                .andExpect(jsonPath("$.dailyTransferLimit").value(customer.getDailyTransferLimit()))
                .andExpect(jsonPath("$.absoluteTransferLimit").value(customer.getAbsoluteTransferLimit()));
    }

    @Test
    @WithMockUser(roles = "EMPLOYEE")
    void getAllUnapprovedCustomersShouldReturn200AndListOfCustomers() throws Exception {
        List<Customer> customers = Collections.singletonList(customer);
        when(customerService.getAllUnapprovedCustomers()).thenReturn(customers);

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/unapproved")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value(customer.getUserId()))
                .andExpect(jsonPath("$[0].firstName").value(customer.getFirstName()))
                .andExpect(jsonPath("$[0].lastName").value(customer.getLastName()))
                .andExpect(jsonPath("$[0].bsnNumber").value(customer.getBsnNumber()))
                .andExpect(jsonPath("$[0].phoneNumber").value(customer.getPhoneNumber()))
                .andExpect(jsonPath("$[0].accountApproved").value(customer.getAccountApproved()))
                .andExpect(jsonPath("$[0].dailyTransferLimit").value(customer.getDailyTransferLimit()))
                .andExpect(jsonPath("$[0].dailyTransferAmount").value(customer.getDailyTransferAmount()))
                .andExpect(jsonPath("$[0].absoluteTransferLimit").value(customer.getAbsoluteTransferLimit()));
    }

    @Test
    @WithMockUser(roles = "EMPLOYEE")
    void approveCustomerShouldReturn200AndCustomer() throws Exception {
        when(customerService.approveCustomer(anyLong())).thenReturn(Optional.of(customer));

        mockMvc.perform(MockMvcRequestBuilders.put("/customers/1/approve")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(customer.getUserId()))
                .andExpect(jsonPath("$.firstName").value(customer.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(customer.getLastName()))
                .andExpect(jsonPath("$.bsnNumber").value(customer.getBsnNumber()))
                .andExpect(jsonPath("$.phoneNumber").value(customer.getPhoneNumber()))
                .andExpect(jsonPath("$.accountApproved").value(customer.getAccountApproved()))
                .andExpect(jsonPath("$.dailyTransferLimit").value(customer.getDailyTransferLimit()))
                .andExpect(jsonPath("$.dailyTransferAmount").value(customer.getDailyTransferAmount()))
                .andExpect(jsonPath("$.absoluteTransferLimit").value(customer.getAbsoluteTransferLimit()));
    }

    @Test
    @WithMockUser(roles = "EMPLOYEE")
    void closeCustomerShouldReturn200AndCustomer() throws Exception {
        when(customerService.closeCustomer(anyLong())).thenReturn(Optional.of(customer));

        mockMvc.perform(MockMvcRequestBuilders.put("/customers/1/close")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(customer.getUserId()))
                .andExpect(jsonPath("$.firstName").value(customer.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(customer.getLastName()))
                .andExpect(jsonPath("$.bsnNumber").value(customer.getBsnNumber()))
                .andExpect(jsonPath("$.phoneNumber").value(customer.getPhoneNumber()))
                .andExpect(jsonPath("$.accountApproved").value(customer.getAccountApproved()))
                .andExpect(jsonPath("$.dailyTransferLimit").value(customer.getDailyTransferLimit()))
                .andExpect(jsonPath("$.dailyTransferAmount").value(customer.getDailyTransferAmount()))
                .andExpect(jsonPath("$.absoluteTransferLimit").value(customer.getAbsoluteTransferLimit()));
    }
}