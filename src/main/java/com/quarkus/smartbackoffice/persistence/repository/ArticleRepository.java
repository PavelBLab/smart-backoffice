package com.quarkus.smartbackoffice.persistence.repository;


import com.quarkus.smartbackoffice.persistence.entity.Article;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ArticleRepository extends CrudService<Article> {

    public ArticleRepository() {
        // For CDI needs
        super(null);
    }

    @Inject
    public ArticleRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }
}
