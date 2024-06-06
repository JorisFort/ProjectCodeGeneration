package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.repository.AccountRepository;
import com.group4.projectcodegeneration.util.IbanGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        String iban = IbanGenerator.generateIban();
        while (accountRepository.findByIban(iban).isPresent()) {
            iban = IbanGenerator.generateIban();
        }
        account.setIban(iban);

        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }
}

