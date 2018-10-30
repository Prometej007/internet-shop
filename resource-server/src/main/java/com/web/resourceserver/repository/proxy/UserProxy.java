package com.web.resourceserver.repository.proxy;

import com.web.resourceserver.config.User;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@FeignClient(name = "auth-service")
public interface UserProxy {

//    @GetMapping("/users/current")
//    Principal find(@RequestHeader("authorization") String principal);
    @GetMapping("/auth/users/find")
    User find(@RequestParam String principal);

}


