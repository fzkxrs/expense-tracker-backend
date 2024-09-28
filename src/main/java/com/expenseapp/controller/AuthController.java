package com.expenseapp.controller;

import com.expenseapp.dto.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // This is where you would typically authenticate the user and generate a token.
        // For simplicity, we're returning a mock token.
        return "Mock JWT token";
    }
}