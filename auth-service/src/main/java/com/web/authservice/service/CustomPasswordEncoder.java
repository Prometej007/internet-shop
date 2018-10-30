package com.web.authservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        System.out.println(charSequence.toString());
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        System.out.println(charSequence.equals(s));
        return charSequence.equals(s);
    }
}
