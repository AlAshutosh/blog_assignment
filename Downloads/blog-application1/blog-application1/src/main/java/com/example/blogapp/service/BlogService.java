package com.example.blogapp.service;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.User;
import com.example.blogapp.repository.BlogRepository;
import com.example.blogapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    // Get Blogs by User
    public List<Blog> getUserBlogs(User user) {
        return blogRepository.findByUser(user);
    }

    // Create a new Blog
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    // Update Blog
    public Blog updateBlog(Long blogId, Blog updatedBlog) {
        Blog existingBlog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setBody(updatedBlog.getBody());
        return blogRepository.save(existingBlog);
    }

    // Delete Blog
    public void deleteBlog(Long blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        blogRepository.delete(blog);
    }
}
