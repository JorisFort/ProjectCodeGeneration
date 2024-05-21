package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
