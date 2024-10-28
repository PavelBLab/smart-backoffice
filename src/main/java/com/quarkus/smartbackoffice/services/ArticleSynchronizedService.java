package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.exceptions.ResourceNotFoundException;
import com.quarkus.smartbackoffice.mappers.ArticleSynchronizedMapper;
import com.quarkus.smartbackoffice.persistence.repository.ArticleSynchronizedRepository;
import com.quarkus.smartbackoffice.provider.models.ArticleDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ArticleSynchronizedService {

    private final ArticleSynchronizedRepository articleSynchronizedRepository;
    private final ArticleSynchronizedMapper articleSynchronizedMapper;

    public List<ArticleDto> allArticles() {
        return articleSynchronizedMapper.mapToArticleDtos(articleSynchronizedRepository.listAll());
    }

    public ArticleDto oneArticle(final Long articleId) {
        val article = articleSynchronizedRepository.findByIdOptional(articleId);

        if (article.isPresent()) {
            return articleSynchronizedMapper.mapToArticleDto(article.get());
        } else {
            throw new ResourceNotFoundException("Article with articleId: " + articleId + " is not found");
        }
    }

    @Transactional
    public ArticleDto createArticle(final ArticleDto articleDto) {
        articleSynchronizedRepository.persist(articleSynchronizedMapper.mapToArticle(articleDto));
        return articleDto;
    }


    @Transactional
    public void deleteArticle(final Long articleId) {
        val article = articleSynchronizedRepository.findByIdOptional(articleId);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with articleId: " + articleId + " is not found");
        }
        articleSynchronizedRepository.deleteById(articleId);
    }

}
