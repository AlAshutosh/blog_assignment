package com.example.blogapp.dto;

public class BlogRequest {
    private Long userId;  // User's ID to associate the blog with a user
    private String title; // Blog title
    private String body;  // Blog body content

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
