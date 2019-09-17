package com.github.willwbowen.account.controller;

import com.github.willwbowen.account.dto.UserDto;
import com.github.willwbowen.account.dto.UserRegistrationDto;
import com.github.willwbowen.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public UserDto createNewAccount(@RequestBody UserRegistrationDto user) {
        return accountService.create(user);
    }
}
