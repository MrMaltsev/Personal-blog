package com.projects.personal_blog;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private final ApiService service;

    ApiController(ApiService service) {
        this.service = service;
    }

    @GetMapping("/api/articles")
    public List<Article> showArticlesPage() {
        return service.getAllArticles();
    }

    @GetMapping("/api/articles/{id}")
    public Article showArticleText(@PathVariable Long id) {
        return service.getArticle(id);
    }

    @PostMapping("/api/articles")
    public Article postNewArticle(@RequestBody Article newArticle) {
        return service.saveNewArticle(newArticle);
    }
}
