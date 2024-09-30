package com.expenseapp.controller;

import lombok.Getter;

@Getter
public class LoginRequest {

    public LoginRequest() {
    }

    private String username;
    private String password;

}