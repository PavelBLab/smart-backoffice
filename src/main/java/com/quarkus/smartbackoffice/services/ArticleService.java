package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.mappers.ArticleMapper;
import com.quarkus.smartbackoffice.persistence.repository.ArticleRepository;
import com.quarkus.smartbackoffice.provider.models.ArticleDto;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository ArticleRepository;
    private final ArticleMapper ArticleMapper;

    public List<ArticleDto> allArticles() {
        return ArticleMapper.mapToArticleDtos(ArticleRepository.listAll());
    }

    public ArticleDto oneArticle(final Long articleId) {
        val Article = ArticleRepository.getById(articleId);

        if (Article.isPresent()) {
            return ArticleMapper.mapToArticleDto(Article.get());
        } else {
            return ArticleDto.builder().build();
        }
    }

    public ArticleDto createArticle(final ArticleDto articleDto) {
        val persistedArticle = ArticleRepository.persist(ArticleMapper.mapToArticle(articleDto));
        return ArticleMapper.mapToArticleDto(persistedArticle);
    }

}
