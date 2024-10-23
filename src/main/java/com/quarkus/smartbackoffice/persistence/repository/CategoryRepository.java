package com.quarkus.smartbackoffice.persistence.repository;


import com.quarkus.smartbackoffice.persistence.entity.Category;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class CategoryRepository extends CrudService<Category> {

    public CategoryRepository() {
        // For CDI needs
        super(null);
    }

    @Inject
    public CategoryRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
