package com.web.authservice.controller;

import com.web.authservice.model.User;
import com.web.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        System.out.println("-------getUser-------");
        System.out.println(principal.getName());
        System.out.println(principal.getName());
        System.out.println(principal.getName());
        System.out.println(principal.getName());
        System.out.println(principal.getName());
        System.out.println(principal.getName());
        System.out.println(principal.getName());

        return principal;
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public User getUs(@RequestParam String principal) {
        System.out.println("/find");
        System.out.println("/find");
        System.err.println(principal);
        System.err.println(principal);
        System.err.println(principal);
        System.err.println(principal);
        System.err.println(principal);
        System.err.println(principal);
        System.err.println(principal);
        System.out.println("/find");
        System.out.println("/find");
        return userService.findByUsername(principal);
    }

    //    @PreAuthorize("#oauth2.hasScope('server')")
//    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/test/create/{username}/{passowrod}", method = RequestMethod.GET)
    public User create(@PathVariable String username, @PathVariable String passowrod) {
        return userService.create(username, passowrod);
    }

}
