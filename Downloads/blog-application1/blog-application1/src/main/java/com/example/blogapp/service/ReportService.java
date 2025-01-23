package com.example.blogapp.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    public Map<String, Long> getTopFrequentWords(Long userId) {
        // Mock implementation: Replace this with actual logic to process blogs
        Map<String, Long> topWords = new HashMap<>();
        topWords.put("example", 5L);
        topWords.put("word", 3L);
        topWords.put("blog", 2L);
        return topWords;
    }
}
