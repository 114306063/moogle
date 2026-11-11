package com.example.moogle.controller;

import com.example.moogle.service.TavilySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    private TavilySearchService tavilySearchService;

    // GET /api/search?q=關鍵字  → 回傳 { "標題": "網址", ... }
    @GetMapping("/api/search")
    public Map<String, String> search(@RequestParam("q") String q) {
        if (q == null || q.trim().isEmpty()) {
            return new LinkedHashMap<>();
        }
        return tavilySearchService.search(q.trim());
    }
}