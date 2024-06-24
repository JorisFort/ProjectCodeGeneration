package com.group4.projectcodegeneration.configuration;

import com.group4.projectcodegeneration.security.JwtProvider;
import org.springframework.boot.test.mock.mockito.MockBean;

@org.springframework.boot.test.context.TestConfiguration
public class ApiTestConfiguration {

    @MockBean
    private JwtProvider jwtProvider;
}
