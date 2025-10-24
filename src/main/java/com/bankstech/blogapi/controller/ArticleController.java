package com.bankstech.blogapi.controller;

import com.bankstech.blogapi.entity.Article;
import com.bankstech.blogapi.model.ResponseMessage;
import com.bankstech.blogapi.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;
    private ResponseMessage rm;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        rm = articleService.createArticle(article);
        if (rm.getType().equals("success")) {
            return new ResponseEntity<>(rm.getData(), rm.getHttpStatus());
        }
        return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
    }

    @GetMapping("/{search}")
    public ResponseEntity<?> filterArticles(@PathVariable String search) {
        rm = articleService.filterArticles(search);
        if (rm.getType().equals("success")) {
            return new ResponseEntity<>(rm.getData(), rm.getHttpStatus());
        }
        return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Long id) {
        rm = articleService.getArticleById(id);
        if (rm.getType().equals("success")) {
            return new ResponseEntity<>(rm.getData(), rm.getHttpStatus());
        }

        return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        rm = articleService.updateArticle(id, article);
        if (rm.getType().equals("success")) {
            return new ResponseEntity<>(rm.getData(), rm.getHttpStatus());
        }
        return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        rm = articleService.deleteArticle(id);
        return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
    }
}