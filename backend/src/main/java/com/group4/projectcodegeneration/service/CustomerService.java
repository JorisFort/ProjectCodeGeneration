package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.model.AccountType;
import com.group4.projectcodegeneration.model.Customer;
import com.group4.projectcodegeneration.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountService accountService;

    public CustomerService(CustomerRepository customerRepository, AccountService accountService) {
        this.customerRepository = customerRepository;
        this.accountService = accountService;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public Iterator<Customer> getAllUnapprovedCustomers() {
        return customerRepository.findByAccountApprovedFalse();
    }

    public Customer approveCustomer(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setAccountApproved(true);
            customerRepository.save(customer);

            Account checking = new Account();
            checking.setCustomer(customer);
            checking.setAccountType(AccountType.CHECKING);
            accountService.createAccount(checking);

            Account savings = new Account();
            savings.setCustomer(customer);
            savings.setAccountType(AccountType.SAVINGS);
            accountService.createAccount(savings);

            return customer;
        } else {
            return null;
        }
    }

    public Customer closeCustomer(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setAccountApproved(false);
            customerRepository.save(customer);
            return customer;
        } else {
            return null;
        }
    }


}
