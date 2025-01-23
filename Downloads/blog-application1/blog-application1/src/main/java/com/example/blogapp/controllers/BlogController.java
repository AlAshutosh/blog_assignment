package com.example.blogapp.controllers;

import com.example.blogapp.dto.BlogRequest;
import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.User;
import com.example.blogapp.service.AuthService;
import com.example.blogapp.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    private final AuthService authService;

    // Fetch blogs for a specific user
    @GetMapping("/user/{userId}")
    public List<Blog> getUserBlogs(@PathVariable Long userId) {
        User user = authService.getUserById(userId);
        return blogService.getUserBlogs(user);
    }

    // Create a new blog
    @PostMapping("/create")
    public Blog createBlog(@RequestBody BlogRequest request) {
        User user = authService.getUserById(request.getUserId());  // Get user by ID from request
        Blog blog = new Blog(request.getTitle(), request.getBody(), user);
        return blogService.createBlog(blog);
    }

    // Update an existing blog
    @PutMapping("/update/{blogId}")
    public Blog updateBlog(@PathVariable Long blogId, @RequestBody BlogRequest request) {
        User user = authService.getUserById(request.getUserId());
        Blog updatedBlog = new Blog(request.getTitle(), request.getBody(), user);
        return blogService.updateBlog(blogId, updatedBlog);
    }

    // Delete a blog
    @DeleteMapping("/delete/{blogId}")
    public void deleteBlog(@PathVariable Long blogId) {
        blogService.deleteBlog(blogId);
    }
}
