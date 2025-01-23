package com.example.blogapp.service;

import com.example.blogapp.entity.User;
import com.example.blogapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Method to get User by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Method to authenticate the user based on username and password
    public User authenticate(String username, String password) {
        // Find the user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Compare the provided password with the stored password
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;  // Authentication successful
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
