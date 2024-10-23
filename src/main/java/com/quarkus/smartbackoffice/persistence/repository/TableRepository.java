package com.quarkus.smartbackoffice.persistence.repository;


import com.quarkus.smartbackoffice.persistence.entity.Table;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class TableRepository extends CrudService<Table> {

    public TableRepository() {
        // For CDI needs
        super(null);
    }

    @Inject
    public TableRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Table> getEntityClass() {
        return Table.class;
    }
}
