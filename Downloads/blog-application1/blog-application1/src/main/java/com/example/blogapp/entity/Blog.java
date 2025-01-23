package com.example.blogapp.entity;

import jakarta.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Default constructor
    public Blog() {
    }

    // Constructor with parameters
    public Blog(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for body
    public String getBody() {
        return body;
    }

    // Getter for user
    public User getUser() {
        return user;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Setter for body
    public void setBody(String body) {
        this.body = body;
    }

    // Setter for user
    public void setUser(User user) {
        this.user = user;
    }
}
