package com.projects.personal_blog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
