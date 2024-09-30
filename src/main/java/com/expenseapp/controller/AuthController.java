package com.expenseapp.controller;

import com.expenseapp.model.User;
import com.expenseapp.service.UserService;
import com.expenseapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;



    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        // Load user and generate JWT token
        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());

        return jwtUtil.generateToken(userDetails.getUsername());
    }

    @PostMapping("/auth/register")
    public String register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request.getUsername(), request.getPassword());
        return "User registered successfully: " + user.getUsername();
    }
}