package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.CategoriesApi;
import com.quarkus.smartbackoffice.provider.models.CategoryDto;
import com.quarkus.smartbackoffice.services.CategoryService;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
//@NonBlocking
public class CategoryController implements CategoriesApi {

    private final CategoryService categoryService;

    @Override
    public Response allCategories() {
        return Response.ok(List.of(categoryService.allCategories())).build();
    }

    @Override
    public Response oneCategory(final Long categoryId) {
        return Response.ok(categoryService.oneCategory(categoryId)).build();
    }

    @Override
    public Response createCategory(final CategoryDto categoryDto) {
        val persistedCategory = categoryService.createCategory(categoryDto);
        return Response.created(URI.create("/Categorys/" + persistedCategory.getId())).build();
    }

    @Override
    public Response updateCategory(final Long categoryId, final CategoryDto categoryDto) {
        return Response.ok().build();
    }

    @Override
    public Response deleteCategory(final Long categoryId) {
        return Response.ok().build();
    }
}
