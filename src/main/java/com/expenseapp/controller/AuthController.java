package com.expenseapp.controller;

import com.expenseapp.model.User;
import com.expenseapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // This is where you would typically authenticate the user and generate a token.
        // For simplicity, we're returning a mock token.
        return "Mock JWT token";
    }

    @PostMapping("/auth/register")
    public String register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request.getUsername(), request.getPassword());
        return "User registered successfully: " + user.getUsername();
    }
}