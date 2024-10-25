package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.exceptions.ResourceNotFoundException;
import com.quarkus.smartbackoffice.mappers.CategoryMapper;
import com.quarkus.smartbackoffice.persistence.repository.CategoryRepository;
import com.quarkus.smartbackoffice.provider.models.CategoryDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> allCategories() {
        return categoryMapper.mapToCategoryDtos(categoryRepository.listAll());
    }

    public CategoryDto oneCategory(final Long categoryId) {
        val category = categoryRepository.findByIdOptional(categoryId);

        if (category.isPresent()) {
            return categoryMapper.mapToCategoryDto(category.get());
        } else {
            throw new ResourceNotFoundException("Category with categoryId: " + categoryId + " is not found");
        }
    }

    @Transactional
    public CategoryDto createCategory(final CategoryDto categoryDto) {
        categoryRepository.persist(categoryMapper.mapToCategory(categoryDto));
        return categoryDto;
    }


    @Transactional
    public void deleteCategory(final Long categoryId) {
        val Category = categoryRepository.findByIdOptional(categoryId);
        if (Category.isEmpty()) {
            throw new NotFoundException("Category with categoryId: " + categoryId + " is not found");
        }
        categoryRepository.deleteById(categoryId);
    }

}