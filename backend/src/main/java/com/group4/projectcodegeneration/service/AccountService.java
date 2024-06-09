package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.model.Customer;
import com.group4.projectcodegeneration.repository.AccountRepository;
import com.group4.projectcodegeneration.repository.CustomerRepository;
import com.group4.projectcodegeneration.util.IbanGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public Account createAccount(Account account) {
        String iban = IbanGenerator.generateIban();
        while (accountRepository.findByIban(iban).isPresent()) {
            iban = IbanGenerator.generateIban();
        }
        account.setIban(iban);

        return accountRepository.save(account);
    }

    public void updateAccount(Account account) {
        // When an account is updated, the customer should be updated as well to keep the daily limit updated
        customerRepository.save(account.getCustomer());
        accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAllCustomerAccounts(Customer customer) {
        return accountRepository.findByCustomer(customer);
    }

    public Optional<Account> getAccountByIban(String iban) {
        return accountRepository.findByIban(iban);
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }
}

