package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.*;
import com.group4.projectcodegeneration.model.dto.LoginResponseDto;
import com.group4.projectcodegeneration.model.dto.RegisterRequestDto;
import com.group4.projectcodegeneration.model.dto.UserDto;
import com.group4.projectcodegeneration.repository.CustomerRepository;
import com.group4.projectcodegeneration.security.JwtProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountService accountService;
    private final UserService userService;
    private final JwtProvider jwtProvider;

    public CustomerService(CustomerRepository customerRepository, AccountService accountService, UserService userService, JwtProvider jwtProvider) {
        this.customerRepository = customerRepository;
        this.accountService = accountService;
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllUnapprovedCustomers() {
        return customerRepository.findByAccountApprovedFalse();
    }

    public LoginResponseDto register(RegisterRequestDto registerRequestDto) {
        User user = new User();
        user.setEmail(registerRequestDto.email());
        user.setPassword(registerRequestDto.password());
        user.setRole(UserRole.CUSTOMER);
        userService.createUser(user);

        Customer customer = new Customer();
        customer.setFirstName(registerRequestDto.firstName());
        customer.setLastName(registerRequestDto.lastName());
        customer.setPhoneNumber(registerRequestDto.phoneNumber());
        customer.setBsnNumber(registerRequestDto.bsnNumber());
        customer.setUser(user);
        customerRepository.save(customer);

        return new LoginResponseDto(new UserDto(user.getId(), user.getEmail(), user.getRole()), jwtProvider.createToken(user));
    }

    public Customer approveCustomer(Long userId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(userId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setAccountApproved(true);
            customerRepository.save(customer);

            Account checking = new Account();
            checking.setCustomer(customer);
            checking.setAccountType(AccountType.CHECKING);
            accountService.createAccount(checking);

            Account savings = new Account();
            savings.setCustomer(customer);
            savings.setAccountType(AccountType.SAVINGS);
            accountService.createAccount(savings);

            return customer;
        } else {
            return null;
        }
    }

    public Customer closeCustomer(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setAccountApproved(false);
            customerRepository.save(customer);
            return customer;
        } else {
            return null;
        }
    }


}
