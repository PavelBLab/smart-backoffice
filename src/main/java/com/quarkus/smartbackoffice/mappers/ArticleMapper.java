package com.quarkus.smartbackoffice.mappers;

import com.quarkus.smartbackoffice.persistence.entity.Article;
import com.quarkus.smartbackoffice.provider.models.ArticleDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ArticleMapper {

    @IterableMapping(qualifiedByName = "mapToArticleDto")
    List<ArticleDto> mapToArticleDtos(final List<Article> articles);

    @Named("mapToArticleDto")
    @Mapping(target = "id", ignore = true)
    ArticleDto mapToArticleDto(final Article article);

    @IterableMapping(qualifiedByName = "mapToArticle")
    List<Article> mapToArticles(final List<ArticleDto> articleDtos);

    @Named("mapToArticle")
    Article mapToArticle(final ArticleDto articleDto);

}
