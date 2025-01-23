package com.example.blogapp.controllers;

import com.example.blogapp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report/{userId}")
    public String generateReport(@PathVariable Long userId, Model model) {

        Map<String, Long> frequentWords = reportService.getTopFrequentWords(userId);

        model.addAttribute("frequentWords", frequentWords);

        return "report";
    }
}
