package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.models.CategoryDto;
import com.quarkus.smartbackoffice.services.CategoryService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class CategoryControllerTest {

    @InjectMock
    CategoryService categoryServiceMock;

    @BeforeEach
    void setup() {
        Mockito.when(categoryServiceMock.oneCategory(null))
                .thenReturn(CategoryDto.builder().name("drinks-test").build());
    }

    @Test
    void categoriesGet() {
        val response = given()
                .when()
                .get("/categories")
                .then()
                .statusCode(200)
                .extract().response();

        val jsonPath = response.jsonPath();

        assertEquals("drinks-test", jsonPath.getString("[0].name"));
    }

    @Test
    void categoriesCategoryIdDelete() {
    }

    @Test
    void categoriesCategoryIdGet() {
    }

    @Test
    void categoriesCategoryIdPut() {
    }

    @Test
    void categoriesPost() {
    }
}