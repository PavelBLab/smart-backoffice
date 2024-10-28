package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.services.ArticleSynchronizedService;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;


/**
 * Response object in the methods is for blocking (synchronized) operations
 * Uni object in the methods is for non-blocking (noo-synchronized) operations
 */
@Slf4j
@RequiredArgsConstructor
@NonBlocking
@Path("/articles")
@Tag(name = "Articles", description = "Endpoints related to managing articles")
public class ArticleNonSynchronizedController {

    private final ArticleSynchronizedService articleSynchronizedService;

    // GET request to get a list of articleDtos using non-blocking operation
    @GET
    @Path("/async/articles")
    public Uni<Response> allArticlesAsync() {
        log.info("Returns all articles (non-blocking)");
        return Uni.createFrom()
                .item(() -> List.of(articleSynchronizedService.allArticles()))
                .runSubscriptionOn(Infrastructure.getDefaultExecutor()) // Offload to a worker thread
                .map(articles -> Response.ok(articles).build());
    }

}
