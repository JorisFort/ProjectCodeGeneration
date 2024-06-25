package com.group4.projectcodegeneration.service;

import com.group4.projectcodegeneration.model.*;
import com.group4.projectcodegeneration.model.dto.LoginResponseDto;
import com.group4.projectcodegeneration.model.dto.RegisterRequestDto;
import com.group4.projectcodegeneration.model.dto.UserDto;
import com.group4.projectcodegeneration.repository.CustomerRepository;
import com.group4.projectcodegeneration.security.JwtProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        User authenticatedUser = userService.getAuthenticatedUser();
        if (authenticatedUser.getRole() == UserRole.ROLE_CUSTOMER && !authenticatedUser.getId().equals(customerId)) throw new InsufficientAuthenticationException("You are not authorized to view this customer");

        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllUnapprovedCustomers() {
        return customerRepository.findByAccountApprovedFalse();
    }

    @Transactional
    public LoginResponseDto register(RegisterRequestDto registerRequestDto) {
        // Create and save the User
        User user = new User();
        user.setEmail(registerRequestDto.email());
        user.setPassword(registerRequestDto.password());
        user.setRole(UserRole.ROLE_CUSTOMER);
        User savedUser = userService.createUser(user); // Ensure this method saves and returns the managed User

        // Create and save the Customer
        Customer customer = new Customer();
        customer.setFirstName(registerRequestDto.firstName());
        customer.setLastName(registerRequestDto.lastName());
        customer.setPhoneNumber(registerRequestDto.phoneNumber());
        customer.setBsnNumber(registerRequestDto.bsnNumber());
        customer.setUser(savedUser);
        customerRepository.save(customer);

        return new LoginResponseDto(new UserDto(savedUser.getId(), savedUser.getEmail(), savedUser.getRole()), jwtProvider.createToken(savedUser));
    }


    public Optional<Customer> approveCustomer(Long userId) {
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

            return Optional.of(customer);
        }

        return optionalCustomer;
    }

    public Optional<Customer> closeCustomer(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setAccountApproved(false);
            customerRepository.save(customer);

            return Optional.of(customer);
        }

        return optionalCustomer;
    }
}
