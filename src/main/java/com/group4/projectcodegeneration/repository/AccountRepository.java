package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
