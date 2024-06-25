package com.group4.projectcodegeneration.configuration;

import com.group4.projectcodegeneration.model.*;
import com.group4.projectcodegeneration.model.dto.LoginRequestDto;
import com.group4.projectcodegeneration.model.dto.LoginResponseDto;
import com.group4.projectcodegeneration.model.dto.RegisterRequestDto;
import com.group4.projectcodegeneration.model.dto.TransactionDto;
import com.group4.projectcodegeneration.repository.CustomerRepository;
import com.group4.projectcodegeneration.service.AccountService;
import com.group4.projectcodegeneration.service.CustomerService;
import com.group4.projectcodegeneration.service.TransactionService;
import com.group4.projectcodegeneration.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class ApplicationStarter implements ApplicationRunner {

    private final UserService userService;
    private final CustomerService customerService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    public ApplicationStarter(UserService userService, CustomerService customerService, AccountService accountService, TransactionService transactionService) {
        this.userService = userService;
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
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

        // Register a Customer
        email = "customer@customer.nl";
        password = "123";

        RegisterRequestDto registerRequestDto = new RegisterRequestDto(email,
                password, "John", "Doe", "123456789", "0612345678");

        LoginResponseDto loginResponseDto = customerService.register(registerRequestDto);

        // Approve the Customer to create the accounts
        Optional<Customer> Customer = customerService.approveCustomer(loginResponseDto.user().id());

        if (Customer.isPresent()) { // Add 1000 deposit to the customer account
            accountService.getAllCustomerAccounts(Customer.get().getUserId()).forEach(account -> {
                TransactionDto transactionDto = new TransactionDto(null, account.getIban(), 1000, TransactionType.DEPOSIT);
                transactionService.createTransaction(transactionDto, Customer.get().getUser());

                if (account.getAccountType() == AccountType.CHECKING) {
                    TransactionDto withdraw = new TransactionDto(account.getIban(), null, 500, TransactionType.WITHDRAWAL);
                    transactionService.createTransaction(withdraw, Customer.get().getUser());
                }
            });
        } else {
            System.out.println("Customer not found during approval process. In application starter.");
        }

        LoginResponseDto customerLogin = userService.login(new LoginRequestDto(email, password));
        System.out.println("Customer email: " + email + " password: " + password);
        System.out.println("Customer token: " + customerLogin.token());
    }
}
