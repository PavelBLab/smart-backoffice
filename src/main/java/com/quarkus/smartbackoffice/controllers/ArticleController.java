package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.ArticlesApi;
import com.quarkus.smartbackoffice.provider.models.Article;
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
    public Response articlesArticleIdDelete(final String articleId) {
        return Response.ok().build();
    }

    @Override
    public Response articlesArticleIdGet(final String articleId) {
        return Response.ok(articleService.articleIdGet(articleId)).build();
    }

    @Override
    public Response articlesArticleIdPut(final String articleId, final Article article) {
        return Response.ok().build();
    }

    @Override
    public Response articlesGet() {
        return Response.ok(List.of(articleService.articleIdGet(null))).build();
    }

    @Override
    public Response articlesPost(final Article article) {
        return Response.created(URI.create("todo")).build();
    }
}
