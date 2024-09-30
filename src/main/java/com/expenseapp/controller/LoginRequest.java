package com.expenseapp.controller;

import lombok.Getter;

@Getter
public record LoginRequest(String username, String password) {
}