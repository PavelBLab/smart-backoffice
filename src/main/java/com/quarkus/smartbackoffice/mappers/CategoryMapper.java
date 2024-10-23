package com.quarkus.smartbackoffice.mappers;

import com.quarkus.smartbackoffice.persistence.entity.Category;
import com.quarkus.smartbackoffice.provider.models.CategoryDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CategoryMapper {

    @IterableMapping(qualifiedByName = "mapToCategoryDto")
    List<CategoryDto> mapToCategoryDtos(final List<Category> categories);

    @Named("mapToCategoryDto")
    CategoryDto mapToCategoryDto(final Category category);

    @IterableMapping(qualifiedByName = "mapToCategory")
    List<Category> mapToCategories(final List<CategoryDto> categoryDtos);

    @Named("mapToCategory")
    Category mapToCategory(final CategoryDto categoryDto);

}
