package com.expenseapp.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {

    public RegisterRequest() {
    }
    private String username;
    private String password;
}