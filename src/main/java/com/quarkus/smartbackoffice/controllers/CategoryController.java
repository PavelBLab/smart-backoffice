package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.CategoriesApi;
import com.quarkus.smartbackoffice.provider.models.Category;
import com.quarkus.smartbackoffice.services.CategoryService;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@NonBlocking
public class CategoryController implements CategoriesApi {


    private final CategoryService categoryService;

    @Inject
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Response categoriesCategoryIdDelete(final String categoryId) {
        return Response.ok().build();
    }

    @Override
    public Response categoriesCategoryIdGet(final String categoryId) {
        return Response.ok(categoryService.categoryIdGet(categoryId)).build();
    }

    @Override
    public Response categoriesCategoryIdPut(final String categoryId, final Category category) {
        return Response.ok().build();
    }

    @Override
    public Response categoriesGet() {
        return Response.ok(List.of(categoryService.categoryIdGet(null))).build();
    }

    @Override
    public Response categoriesPost(final Category category) {
        return Response.created(URI.create("todo")).build();
    }
}
