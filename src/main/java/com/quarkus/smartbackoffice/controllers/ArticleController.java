package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.ArticlesApi;
import com.quarkus.smartbackoffice.provider.models.ArticleDto;
import com.quarkus.smartbackoffice.services.ArticleService;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
//@NonBlocking
@Path("/articles")
@Tag(name = "Articles", description = "Endpoints related to managing articles")
public class ArticleController implements ArticlesApi {

    private final ArticleService articleService;

    @Override
    public Response allArticles() {
        return Response.ok(List.of(articleService.allArticles())).build();
    }

    @Override
    public Response oneArticle(final Long articleId) {
        return Response.ok(articleService.oneArticle(articleId)).build();
    }

    @Override
    public Response createArticle(final Long xCategoryId, final ArticleDto articleDto) {
        val persistedArticle = articleService.createArticle(articleDto);
        return Response.created(URI.create("/Articles/" + persistedArticle.getId())).build();
    }

    @Override
    public Response updateArticle(final Long articleId, final ArticleDto articleDto) {
        return Response.ok().build();
    }

    @Override
    public Response deleteArticle(final Long articleId) {
        return Response.ok().build();
    }
}
