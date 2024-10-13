package com.expenseapp.controller;

import com.expenseapp.request.SumRequest;
import com.expenseapp.service.UserService;
import com.expenseapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public DataController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/api/sum")
    public ResponseEntity<SumRequest> sum(@RequestBody SumRequest sumRequest) {

        // Load user and generate JWT token
        return ResponseEntity.ok(sumRequest);
    }
}