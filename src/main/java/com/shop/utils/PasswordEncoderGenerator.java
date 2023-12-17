package com.shop.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerator {
	// Main method to generate and print a bcrypt-encoded password
    public static void main(String[] args) {
    	// Create a BCryptPasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        // Encode and print the password "admin"
        System.out.println(passwordEncoder.encode("admin"));
    }
}