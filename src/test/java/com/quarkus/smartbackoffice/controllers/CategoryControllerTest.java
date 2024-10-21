package com.quarkus.smartbackoffice.controllers;

import lombok.val;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryControllerTest {

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
    void categoriesGet() {
        val response = given()
                .when()
                .get("/categories")
                .then()
                .statusCode(200)
                .extract().response();

        val jsonPath = response.jsonPath();

        assertEquals("drinks", jsonPath.getString("[0].name"));
    }

    @Test
    void categoriesPost() {
    }
}