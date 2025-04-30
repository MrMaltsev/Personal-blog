package com.projects.personal_blog;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    private String articleName;
    private String articleShortDescription;
    private String articleText;

    private LocalDateTime createDate;
    private LocalDateTime lastUpdatedDate;

    public Article() {}

    public Article(String articleName, String articleShortDescription, String articleText) {
        this.articleName = articleName;
        this.articleShortDescription = articleShortDescription;
        this.articleText = articleText;

        createDate = LocalDateTime.now();
        lastUpdatedDate = LocalDateTime.now();
    }
}
