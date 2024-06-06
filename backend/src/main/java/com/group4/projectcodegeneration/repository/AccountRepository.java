package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByIban(String iban);
}
