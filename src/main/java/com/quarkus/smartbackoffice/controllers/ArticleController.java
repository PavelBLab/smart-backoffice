package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.ArticlesApi;
import com.quarkus.smartbackoffice.provider.models.ArticleDto;
import com.quarkus.smartbackoffice.services.ArticleSynchronizedService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;


/**
 * Response object in the methods is for blocking (synchronized) operations
 * Uni object in the methods is for non-blocking (noo-synchronized) operations
 */
@Slf4j
@Blocking
@Path("/articles")
@RequiredArgsConstructor
@Tag(name = "Articles", description = "Endpoints related to managing articles")
@RolesAllowed("admin")
public class ArticleController implements ArticlesApi {

    private final ArticleSynchronizedService articleSynchronizedService;

    @Override
    public Response allArticles() {
        log.info("Returns all articles");
        return Response.ok(List.of(articleSynchronizedService.allArticles())).build();
    }

    @Override
    public Response oneArticle(final Long articleId) {
        val article = articleSynchronizedService.oneArticle(articleId);
        log.info("Returns a article with articleId: " + article.getId());
        return Response.ok(article).build();
    }

    @Override
    public Response createArticle(final Long xCategoryId, final ArticleDto articleDto) {
        val persistedArticle = articleSynchronizedService.createArticle(articleDto);
        log.info("Creates a article with name: " + articleDto.getName());
        return Response.created(URI.create("/articles/" + persistedArticle.getId())).build();
    }

    @Override
    public Response updateArticle(final Long articleId, final ArticleDto articleDto) {
        return Response.ok().build();
    }

    @Override
    public Response deleteArticle(final Long articleId) {
        articleSynchronizedService.deleteArticle(articleId);
        log.info("Deletes a article with articleId: " + articleId);
        return Response.noContent().build();
    }
}
