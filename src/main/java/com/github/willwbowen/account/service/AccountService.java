package com.github.willwbowen.account.service;

import com.github.willwbowen.account.dto.UserDto;
import com.github.willwbowen.account.dto.UserRegistrationDto;

public interface AccountService {
    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    UserDto create(UserRegistrationDto user);
}
