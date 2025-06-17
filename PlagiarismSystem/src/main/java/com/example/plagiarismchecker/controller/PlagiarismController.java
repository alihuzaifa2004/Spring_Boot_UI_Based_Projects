package com.example.plagiarismchecker.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.plagiarismchecker.service.PlagiarismService;

@RestController
@RequestMapping("/api")
public class PlagiarismController {

    private final PlagiarismService plagiarismService;

    public PlagiarismController(PlagiarismService plagiarismService) {
        this.plagiarismService = plagiarismService;
    }

    @PostMapping("/compare")
    public ResponseEntity<String> compareFiles(@RequestParam("file1") MultipartFile file1,
                                               @RequestParam("file2") MultipartFile file2,
                                               @RequestParam("model") String model) {
        double score = plagiarismService.compare(file1, file2, model);
        return ResponseEntity.ok("Similarity Score: " + String.format("%.2f", score * 100) + "%");
    }

    @PostMapping("/compare/highlight")
    public ResponseEntity<Map<String, String>> compareAndHighlight(
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("model") String model) {  // ✅ FIXED: Add model parameter

        Map<String, String> result = plagiarismService.compareAndHighlight(file1, file2, model);
        return ResponseEntity.ok(result);
    }
}
