package com.TheTrueHooha.UserRegistration.Configurations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoded {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "";
        String encryption = encoder.encode(password);

    }
}
