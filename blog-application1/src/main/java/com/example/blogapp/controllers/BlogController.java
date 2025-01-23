package com.example.blogapp.controllers;

import com.example.blogapp.dto.BlogRequest;
import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.User;
import com.example.blogapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;


    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping("/user/{userId}")
    public List<Blog> getUserBlogs(@PathVariable Long userId) {

        User user = new User();
        user.setId(userId);
        return blogService.getUserBlogs(user.getId());
    }

    // Create a new blog
    @PostMapping("/create")
    public Blog createBlog(@RequestBody BlogRequest blogRequest) {


        Long userId = 1L;
        User user = new User(userId, "testUser", "password123");

        Blog newBlog = new Blog(blogRequest.getTitle(), blogRequest.getBody(), user);
        return blogService.createBlog(newBlog);
    }

    // Update an existing blog
    @PutMapping("/update/{blogId}")
    public Blog updateBlog(@PathVariable Long blogId, @RequestBody BlogRequest updatedBlog) {
        // Similarly, retrieve the user for updating
        Long userId = 1L; // Retrieve the logged-in user's ID here
        User user = new User(userId, "testUser", "password123"); // Example - fetch real user info

        Blog blogToUpdate = new Blog(updatedBlog.getTitle(), updatedBlog.getBody(), user);
        return blogService.updateBlog(blogId, blogToUpdate);
    }

    // Delete a blog
    @DeleteMapping("/delete/{blogId}")
    public String deleteBlog(@PathVariable Long blogId) {
        blogService.deleteBlog(blogId);
        return "Blog deleted successfully!";
    }
}
