package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.provider.models.GeneratedCategory;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryService {

    public GeneratedCategory oneCategory(final Long categoryId) {
        return GeneratedCategory.builder().name("drinks").build();
    }

}
