package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
