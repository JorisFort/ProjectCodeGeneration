package com.group4.projectcodegeneration.repository;

import com.group4.projectcodegeneration.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
