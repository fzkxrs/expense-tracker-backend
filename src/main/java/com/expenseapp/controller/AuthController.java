package com.expenseapp.controller;

import com.expenseapp.model.User;
import com.expenseapp.request.LoginRequest;
import com.expenseapp.request.RegisterRequest;
import com.expenseapp.service.UserService;
import com.expenseapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {

        // Load user and generate JWT token
        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.username());

        // Generate the token
        String token = jwtUtil.generateToken(userDetails.getUsername());

        // Create response body with the token
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("token", token);

        // Return response entity with token as JSON
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request.getUsername(), request.getPassword());

        // Prepare response after successful registration
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "User registered successfully: " + user.getUsername());

        return ResponseEntity.ok(responseBody);
    }
}