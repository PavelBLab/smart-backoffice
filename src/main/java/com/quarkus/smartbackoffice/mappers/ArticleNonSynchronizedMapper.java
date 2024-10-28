//package com.quarkus.smartbackoffice.mappers;
//
//import com.quarkus.smartbackoffice.persistence.entity.Article;
//import com.quarkus.smartbackoffice.persistence.entity.Article2;
//import com.quarkus.smartbackoffice.provider.models.ArticleDto;
//import io.smallrye.mutiny.Uni;
//import org.mapstruct.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
//public interface ArticleNonSynchronizedMapper {
//
//    ArticleDto mapToArticleDto(Article2 article);
//
//    // Custom method for mapping a list of Articles to a List of ArticleDtos using non-blocking operation
//    default Uni<List<ArticleDto>> mapToArticleDtos(Uni<List<Article2>> articlesUni) {
//        return articlesUni.onItem().transform(articles ->
//                articles.stream()
//                        .map(this::mapToArticleDto)
//                        .collect(Collectors.toList())
//        );
//    }
//}
