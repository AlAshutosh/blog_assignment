package com.example.blogapp.service;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService() {

        this.blogRepository = null;
    }

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getUserBlogs(Long userId) {

        return blogRepository.findByUserId(userId);
    }

    // Method to create a new blog
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    // Method to update an existing blog
    public Blog updateBlog(Long blogId, Blog updatedBlog) {
        Blog existingBlog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setBody(updatedBlog.getBody());
        return blogRepository.save(existingBlog);
    }

    // Method to delete a blog
    public void deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
    }
}
