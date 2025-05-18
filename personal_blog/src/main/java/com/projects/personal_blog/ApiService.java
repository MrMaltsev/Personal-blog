package com.projects.personal_blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Article getArticle(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
    }

    public Article saveNewArticle(Article newArticle) {
        newArticle.setCreateDate(LocalDateTime.now());
        newArticle.setLastUpdatedDate(LocalDateTime.now());
        return articleRepository.save(newArticle);
    }
}
