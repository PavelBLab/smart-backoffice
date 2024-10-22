package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.provider.models.Category;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryService {

    public Category categoryIdGet(final String categoryId) {
        return Category.builder().name("drinks").build();
    }

}
