//
//package com.quarkus.smartbackoffice.services;
//
//import com.quarkus.smartbackoffice.mappers.ArticleNonSynchronizedMapper;
//import com.quarkus.smartbackoffice.persistence.repository.ArticleNonSynchronizedRepository;
//import com.quarkus.smartbackoffice.provider.models.ArticleDto;
//import io.smallrye.mutiny.Uni;
//import jakarta.enterprise.context.ApplicationScoped;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//
//@ApplicationScoped
//@RequiredArgsConstructor
//public class ArticleNonSynchronizedService {
//
//    private final ArticleNonSynchronizedRepository articleNonSynchronizedRepository;
//    private final ArticleNonSynchronizedMapper articleNonSynchronizedMapper;
//
//    public Uni<List<ArticleDto>> allArticles() {
//        return articleNonSynchronizedMapper.mapToArticleDtos(articleNonSynchronizedRepository.listAll());
//    }
//
//}
