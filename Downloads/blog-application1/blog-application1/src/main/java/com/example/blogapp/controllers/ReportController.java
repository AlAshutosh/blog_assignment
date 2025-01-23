package com.example.blogapp.controllers;

import com.example.blogapp.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/top-words")
    public Map<String, Long> getTopWords(@RequestParam Long userId) {
        return reportService.getTopFrequentWords(userId);
    }
}
