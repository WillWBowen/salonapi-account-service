package com.github.willwbowen.account.client;

import com.github.willwbowen.account.dto.UserDto;
import com.github.willwbowen.account.dto.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authenticationservice")
public interface AuthServiceFeignClient {
    @PostMapping(value="/uaa/user")
    UserDto createUser(@RequestBody UserRegistrationDto user);
}
