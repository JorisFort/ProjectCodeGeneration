package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.model.Account;
import com.group4.projectcodegeneration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByIban(String iban);
    Iterable<Account> findByCustomer(Customer customer);
}
