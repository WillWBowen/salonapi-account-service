package com.github.willwbowen.account.service;

import com.github.willwbowen.account.client.AuthServiceFeignClient;
import com.github.willwbowen.account.dto.UserDto;
import com.github.willwbowen.account.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AuthServiceFeignClient authServiceClient;

    @Autowired
    public AccountServiceImpl(AuthServiceFeignClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @Override
    public UserDto create(UserRegistrationDto user) {
        return authServiceClient.createUser(user);
    }
}
