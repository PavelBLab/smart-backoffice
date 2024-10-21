package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.ArticlesApi;
import com.quarkus.smartbackoffice.provider.models.Article;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@NonBlocking
public class ArticleController implements ArticlesApi {

    private final Article article = Article.builder().name("articles").build();

    @Override
    public Response articlesArticleIdDelete(final String articleId) {
        return Response.ok().build();
    }

    @Override
    public Response articlesArticleIdGet(final String articleId) {
        return Response.ok(article).build();
    }

    @Override
    public Response articlesArticleIdPut(final String articleId, final Article article) {
        return Response.ok().build();
    }

    @Override
    public Response articlesGet() {
        return Response.ok(List.of(article)).build();
    }

    @Override
    public Response articlesPost(final Article article) {
        return Response.created(URI.create("todo")).build();
    }
}
