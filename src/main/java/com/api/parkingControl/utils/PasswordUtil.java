package com.api.parkingControl.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    public static String encoder(String password) {
        BCryptPasswordEncoder encoderPass = new BCryptPasswordEncoder();
        return encoderPass.encode(password);
    }
}
