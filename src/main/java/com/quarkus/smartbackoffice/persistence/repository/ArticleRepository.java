package com.quarkus.smartbackoffice.persistence.repository;


import com.quarkus.smartbackoffice.persistence.entity.Article;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArticleRepository implements PanacheRepositoryBase<Article, Long> {
}
