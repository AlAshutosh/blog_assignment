package com.example.blogapp.repository;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByUser(User user);
    List<Blog> findByUserId(Long userId);
}
