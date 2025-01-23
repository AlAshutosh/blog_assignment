package com.example.blogapp.service;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final BlogRepository blogRepository;

    @Autowired
    public ReportService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    // Method to get top 5 frequent words
    public Map<String, Long> getTopFrequentWords(Long userId) {
        // Fetch all blogs for the user
        List<Blog> userBlogs = blogRepository.findByUserId(userId);

        String allContent = userBlogs.stream()
                .map(Blog::getBody) // Use the `getBody()` method from Blog entity
                .filter(Objects::nonNull) // Exclude null bodies
                .collect(Collectors.joining(" "));

        Map<String, Long> wordFrequency = Arrays.stream(allContent.split("\\s+")) // Split by spaces
                .map(String::toLowerCase) // Convert to lowercase for consistent counting
                .filter(word -> word.length() > 2) // Exclude short words like "a", "is"
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return wordFrequency.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
