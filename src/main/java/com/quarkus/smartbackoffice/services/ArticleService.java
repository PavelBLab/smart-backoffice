package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.provider.models.Article;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArticleService {

    public Article articleIdGet(final String articleId) {
        return Article.builder().name("pepsi").build();
    }

}
