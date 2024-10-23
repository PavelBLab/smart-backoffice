package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.mappers.CategoryMapper;
import com.quarkus.smartbackoffice.persistence.repository.CategoryRepository;
import com.quarkus.smartbackoffice.provider.models.CategoryDto;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository CategoryRepository;
    private final CategoryMapper CategoryMapper;

    public List<CategoryDto> allCategories() {
        return CategoryMapper.mapToCategoryDtos(CategoryRepository.listAll());
    }

    public CategoryDto oneCategory(final Long CategoryId) {
        val Category = CategoryRepository.getById(CategoryId);

        if (Category.isPresent()) {
            return CategoryMapper.mapToCategoryDto(Category.get());
        } else {
            return CategoryDto.builder().build();
        }
    }

    public CategoryDto createCategory(final CategoryDto CategoryDto) {
        val persistedCategory = CategoryRepository.persist(CategoryMapper.mapToCategory(CategoryDto));
        return CategoryMapper.mapToCategoryDto(persistedCategory);
    }

}
