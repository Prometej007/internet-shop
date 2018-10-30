package com.web.authservice.service.utils;

import com.web.authservice.service.UserService;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CustomUserDetailsService.class);

    public CustomUserDetailsService() {
        System.out.println("["+"init sout CustomUserDetailsService"+"]---------------------------");
        logger.info("init CustomUserDetailsService");
        logger.debug("init CustomUserDetailsService");
        logger.error("init CustomUserDetailsService");
        logger.log(Priority.toPriority(Priority.ALL_INT),"init CustomUserDetailsService");
    }

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.err.println("=wqeqweqw=e=qwe=qwe=qweqw=e==wqeqweqw=e=qwe=qwe=qweqw=e==wqeqweqw=e=qwe=qwe=qweqw=e==wqeqweqw=e=qwe=qwe=qweqw=e==wqeqweqw=e=qwe=qwe=qweqw=e==wqeqweqw=e=qwe=qwe=qweqw=e=");

        logger.info("["+s+"]------------------------------------------" +
                "----------------------------------------------------" +
                "-------------------------------------------------" +
                "---------------------");
        System.out.println("["+s+"]---------------------------");
        return userService.findByUsername(s);
    }
}
