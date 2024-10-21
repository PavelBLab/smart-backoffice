package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.CategoriesApi;
import com.quarkus.smartbackoffice.provider.models.Category;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@NonBlocking
public class CategoryController implements CategoriesApi {


    private final Category category = Category.builder().name("drinks").build();


    @Override
    public Response categoriesCategoryIdDelete(final String categoryId) {
        return Response.ok().build();
    }

    @Override
    public Response categoriesCategoryIdGet(final String categoryId) {
        return Response.ok(category).build();
    }

    @Override
    public Response categoriesCategoryIdPut(final String categoryId, final Category category) {
        return Response.ok().build();
    }

    @Override
    public Response categoriesGet() {
        return Response.ok(List.of(category)).build();
    }

    @Override
    public Response categoriesPost(final Category category) {
        return Response.created(URI.create("todo")).build();
    }
}
