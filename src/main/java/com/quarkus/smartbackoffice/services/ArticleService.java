package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.exceptions.ResourceNotFoundException;
import com.quarkus.smartbackoffice.mappers.ArticleMapper;
import com.quarkus.smartbackoffice.persistence.repository.ArticleRepository;
import com.quarkus.smartbackoffice.provider.models.ArticleDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public List<ArticleDto> allArticles() {
        return articleMapper.mapToArticleDtos(articleRepository.listAll());
    }

    public ArticleDto oneArticle(final Long articleId) {
        val article = articleRepository.findByIdOptional(articleId);

        if (article.isPresent()) {
            return articleMapper.mapToArticleDto(article.get());
        } else {
            throw new ResourceNotFoundException("Article with articleId: " + articleId + " is not found");
        }
    }

    @Transactional
    public ArticleDto createArticle(final ArticleDto articleDto) {
        articleRepository.persist(articleMapper.mapToArticle(articleDto));
        return articleDto;
    }


    @Transactional
    public void deleteArticle(final Long articleId) {
        val article = articleRepository.findByIdOptional(articleId);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with articleId: " + articleId + " is not found");
        }
        articleRepository.deleteById(articleId);
    }

}
