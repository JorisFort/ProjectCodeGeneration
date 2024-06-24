package com.group4.projectcodegeneration.configuration;

import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.model.UserRole;
import com.group4.projectcodegeneration.model.dto.LoginRequestDto;
import com.group4.projectcodegeneration.model.dto.LoginResponseDto;
import com.group4.projectcodegeneration.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationStarter implements ApplicationRunner {

    private final UserService userService;

    public ApplicationStarter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User employee = new User();
        String email = "employee@bank.nl";
        String password = "123";

        employee.setEmail(email);
        employee.setPassword(password);
        employee.setRole(UserRole.ROLE_EMPLOYEE);
        userService.createUser(employee);

        LoginResponseDto employeeLogin = userService.login(new LoginRequestDto(email, password));
        System.out.println("Employee email: " + email + " password: " + password);
        System.out.println("Employee token: " + employeeLogin.token());

        System.out.println();

        // Create a customer
        User customer = new User();
        email = "customer@customer.nl";
        password = "123";

        customer.setEmail(email);
        customer.setPassword(password);
        customer.setRole(UserRole.ROLE_CUSTOMER);
        userService.createUser(customer);

        LoginResponseDto customerLogin = userService.login(new LoginRequestDto(email, password));
        System.out.println("Customer email: " + email + " password: " + password);
        System.out.println("Customer token: " + customerLogin.token());
    }
}
