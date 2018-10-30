package com.web.resourceserver.controller;

import com.web.resourceserver.repository.proxy.UserProxy;
import com.web.resourceserver.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserProxy userProxy;
    @Autowired
    private ImageService imageService;

    //    @PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping
    private ResponseEntity test(Principal authorization) {
        System.out.println("-----------test-----------");
        System.out.println(authorization.getName());
        System.out.println("-----------test-----------");
        return ResponseEntity.ok(userProxy.find(authorization.getName()));
    }
}
