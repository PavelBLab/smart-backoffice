package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.CategoriesApi;
import com.quarkus.smartbackoffice.provider.models.GeneratedCategory;
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
    public Response deleteCategory(final Long categoryId) {
        return Response.ok().build();
    }

    @Override
    public Response oneCategory(final Long categoryId) {
        return Response.ok(categoryService.oneCategory(categoryId)).build();
    }

    @Override
    public Response updateCategory(final Long categoryId, final GeneratedCategory category) {
        return Response.ok().build();
    }

    @Override
    public Response allCategories() {
        return Response.ok(List.of(categoryService.oneCategory(null))).build();
    }

    @Override
    public Response createCategory(final GeneratedCategory category) {
        return Response.created(URI.create("todo")).build();
    }
}
