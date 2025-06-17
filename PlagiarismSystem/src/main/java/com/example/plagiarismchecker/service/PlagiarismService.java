package com.example.plagiarismchecker.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.micrometer.core.instrument.util.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
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

    public Map<String, String> compareAndHighlight(MultipartFile file1, MultipartFile file2, String model) {
        try {
            String text1 = extractText(file1);
            String text2 = extractText(file2);

            Set<String> commonWords = findCommonWords(text1, text2);

            String highlighted1 = highlightText(text1, commonWords);
            String highlighted2 = highlightText(text2, commonWords);

            double similarityScore = "tfidf".equalsIgnoreCase(model) ?
                    tfidfSimilarity(text1, text2) : basicSimilarity(text1, text2);

            Map<String, String> result = new HashMap<>();
            result.put("highlightedText1", highlighted1);
            result.put("highlightedText2", highlighted2);
            result.put("similarity", String.format("%.2f", similarityScore * 100) + "%");

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    private Set<String> findCommonWords(String text1, String text2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(text1.toLowerCase().split("\\W+")));
        Set<String> set2 = new HashSet<>(Arrays.asList(text2.toLowerCase().split("\\W+")));
        set1.retainAll(set2);
        return set1;
    }

    private String highlightText(String text, Set<String> commonWords) {
        StringBuilder sb = new StringBuilder();
        for (String word : text.split("(?<=\\W)|(?=\\W)")) {
            if (commonWords.contains(word.toLowerCase())) {
                sb.append("<mark>").append(word).append("</mark>");
            } else {
                sb.append(word);
            }
        }
        return sb.toString();
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

    // TODO: Replace this with a proper TF-IDF implementation
    private double tfidfSimilarity(String text1, String text2) {
        return basicSimilarity(text1, text2);
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
