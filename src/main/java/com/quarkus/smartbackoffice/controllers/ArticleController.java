package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.ArticlesApi;
import com.quarkus.smartbackoffice.provider.models.GeneratedArticle;
import com.quarkus.smartbackoffice.services.ArticleService;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@NonBlocking
public class ArticleController implements ArticlesApi {

    private final ArticleService articleService;

    @Inject
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public Response deleteArticle(final Long articleId) {
        return Response.ok().build();
    }

    @Override
    public Response oneArticle(final Long articleId) {
        return Response.ok(articleService.oneArticle(articleId)).build();
    }

    @Override
    public Response updateArticle(final Long articleId, final GeneratedArticle article) {
        return Response.ok().build();
    }

    @Override
    public Response allArticles() {
        return Response.ok(List.of(articleService.oneArticle(null))).build();
    }

    @Override
    public Response createArticle(Long xCategoryId, final GeneratedArticle article) {
        return Response.created(URI.create("todo")).build();
    }
}
