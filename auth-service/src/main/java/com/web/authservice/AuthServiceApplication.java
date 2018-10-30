package com.web.authservice;

import com.web.authservice.model.Role;
import com.web.authservice.model.User;
import com.web.authservice.service.CustomPasswordEncoder;
import com.web.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.LinkedList;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }


    @Bean
   public String testttttt(@Autowired
            UserService userService
    ) {
        List<User> accountsList = new LinkedList<>();

        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        user.grantAuthority(Role.ROLE_USER);
        accountsList.add(user);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("password");
        admin.grantAuthority(Role.ROLE_ADMIN);

        accountsList.add(admin);

        accountsList.forEach(
                acct -> {
                    userService.save(acct);
                }
        );
    return "testt";
    }
    @Bean
    public PasswordEncoder CustomPasswordEncoder(){
        return new CustomPasswordEncoder();
    }
}
