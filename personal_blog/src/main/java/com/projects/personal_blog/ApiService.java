package com.projects.personal_blog;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    private final ArticleRepository articleRepository;

    ApiService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
