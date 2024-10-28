package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.persistence.entity.Category;
import com.quarkus.smartbackoffice.persistence.repository.CategoryRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class CategoryControllerTest {

    @InjectMock
    CategoryRepository categoryRepositoryMock;

    @BeforeEach
    void setup() {
        val category = Category.builder().name("drinks-test").build();
        Mockito.when(categoryRepositoryMock.listAll()).thenReturn(List.of(category));
    }

    @Test
    @TestSecurity(authorizationEnabled = false, user = "bob", roles = {"admin"})
    void categoriesGet() {
        val response = given()
                .when()
                .get("/categories")
                .then()
                .statusCode(200)
                .extract().response();

        val jsonPath = response.jsonPath();

        assertEquals("drinks-test", jsonPath.getString("[0].name[0]"));
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