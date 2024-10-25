package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.ArticlesApi;
import com.quarkus.smartbackoffice.provider.models.ArticleDto;
import com.quarkus.smartbackoffice.services.ArticleService;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
//@NonBlocking
@Path("/articles")
@Tag(name = "Articles", description = "Endpoints related to managing articles")
public class ArticleController implements ArticlesApi {

    private final ArticleService articleService;

    @Override
    public Response allArticles() {
        log.info("Returns all articles");
        return Response.ok(List.of(articleService.allArticles())).build();
    }

    @Override
    public Response oneArticle(final Long articleId) {
        val article = articleService.oneArticle(articleId);
        log.info("Returns a article with articleId: " + article.getId());
        return Response.ok(article).build();
    }

    @Override
    public Response createArticle(final Long xCategoryId, final ArticleDto articleDto) {
        val persistedArticle = articleService.createArticle(articleDto);
        log.info("Creates a article with name: " + articleDto.getName());
        return Response.created(URI.create("/articles/" + persistedArticle.getId())).build();
    }

    @Override
    public Response updateArticle(final Long articleId, final ArticleDto articleDto) {
        return Response.ok().build();
    }

    @Override
    public Response deleteArticle(final Long articleId) {
        articleService.deleteArticle(articleId);
        log.info("Deletes a article with articleId: " + articleId);
        return Response.noContent().build();
    }
}
