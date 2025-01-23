package com.example.blogapp.entity;

public class User {
    private Long id;
    private String username;
    private String password;

    // Constructor
    public User() {}

    // Getters and Setters for username and password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Optional: If you're using an ID as the primary key, include it as well
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
