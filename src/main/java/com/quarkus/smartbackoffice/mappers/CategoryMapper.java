package com.quarkus.smartbackoffice.mappers;

import com.quarkus.smartbackoffice.persistence.entity.Category;
import com.quarkus.smartbackoffice.provider.models.CategoryDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CategoryMapper {

    @IterableMapping(qualifiedByName = "mapToCategoryDto")
    List<CategoryDto> mapToCategoryDtos(final List<Category> categories);

    @Named("mapToCategoryDto")
    @Mapping(target = "id", ignore = true)
    CategoryDto mapToCategoryDto(final Category category);

    @IterableMapping(qualifiedByName = "mapToCategory")
    List<Category> mapToCategories(final List<CategoryDto> categoryDtos);

    @Named("mapToCategory")
    Category mapToCategory(final CategoryDto categoryDto);

}
