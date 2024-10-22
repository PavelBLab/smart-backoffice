package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.provider.models.GeneratedArticle;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArticleService {

    public GeneratedArticle oneArticle(final Long articleId) {
        return GeneratedArticle.builder().name("pepsi").build();
    }

}
