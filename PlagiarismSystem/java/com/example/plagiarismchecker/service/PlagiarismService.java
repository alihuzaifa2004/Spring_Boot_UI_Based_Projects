package com.example.plagiarismchecker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlagiarismService {

    public double compare(MultipartFile file1, MultipartFile file2, String model) {
        try {
            String text1 = extractText(file1);
            String text2 = extractText(file2);

            if ("tfidf".equalsIgnoreCase(model)) {
                return tfidfSimilarity(text1, text2);
            } else {
                return basicSimilarity(text1, text2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    private String extractText(MultipartFile file) throws Exception {
        String name = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        if (name.endsWith(".pdf")) {
            PDDocument doc = PDDocument.load(inputStream);
            String text = new PDFTextStripper().getText(doc);
            doc.close();
            return text;
        } else if (name.endsWith(".docx")) {
            XWPFDocument docx = new XWPFDocument(inputStream);
            List<XWPFParagraph> paragraphs = docx.getParagraphs();
            return paragraphs.stream().map(XWPFParagraph::getText).collect(Collectors.joining("\n"));
        } else {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    private double tfidfSimilarity(String text1, String text2) {
        return basicSimilarity(text1, text2); // Placeholder
    }

    private double basicSimilarity(String text1, String text2) {
        String[] words1 = text1.toLowerCase().split("\\W+");
        String[] words2 = text2.toLowerCase().split("\\W+");
        long matches = 0;
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equals(word2)) {
                    matches++;
                    break;
                }
            }
        }
        return (double) matches / Math.max(words1.length, words2.length);
    }
}
