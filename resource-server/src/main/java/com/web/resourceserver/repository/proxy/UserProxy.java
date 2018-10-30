package com.web.resourceserver.repository.proxy;

import com.web.resourceserver.config.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "auth-service")
public interface UserProxy {

    @GetMapping("/auth/users/find")
    User find(@RequestParam String principal);

}


