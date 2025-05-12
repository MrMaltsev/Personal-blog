package com.projects.personal_blog;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(Long id) {
      super("Could not find article" + id);
    }
}
