package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.CategoriesApi;
import com.quarkus.smartbackoffice.provider.models.CategoryDto;
import com.quarkus.smartbackoffice.services.CategoryService;
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

@RequiredArgsConstructor
@Blocking
@Slf4j
@Path("/categories")
@Tag(name = "Categories", description = "Endpoints related to managing categories")
@RolesAllowed("admin")
public class CategoryController implements CategoriesApi {

    private final CategoryService categoryService;

    @Override
    public Response allCategories() {
        log.info("Returns all categories");
        return Response.ok(List.of(categoryService.allCategories())).build();
    }

    @Override
    public Response oneCategory(final Long categoryId) {
        val category = categoryService.oneCategory(categoryId);
        log.info("Returns a Category with categoryId: " + category.getId());
        return Response.ok(category).build();
    }

    @Override
    public Response createCategory(final CategoryDto categoryDto) {
        val persistedCategory = categoryService.createCategory(categoryDto);
        log.info("Creates a Category with name: " + categoryDto.getName());
        return Response.created(URI.create("/categories/" + persistedCategory.getId())).build();
    }

    @Override
    public Response updateCategory(final Long categoryId, final CategoryDto categoryDto) {
        return Response.ok().build();
    }

    @Override
    public Response deleteCategory(final Long categoryId) {
        categoryService.deleteCategory(categoryId);
        log.info("Deletes a category with categoryId: " + categoryId);
        return Response.noContent().build();
    }
}
