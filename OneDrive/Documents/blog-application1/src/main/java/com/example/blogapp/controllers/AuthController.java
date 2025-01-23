package com.example.blogapp.controllers;

import com.example.blogapp.dto.LoginRequest;
import com.example.blogapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();


        if (authService.login(username, password)) {
            return "Login successful!";
        } else {
            return "Invalid username or password!";
        }
    }
}
