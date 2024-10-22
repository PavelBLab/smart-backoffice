package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.persistence.CrudService;
import com.quarkus.smartbackoffice.persistence.entity.Table;
import com.quarkus.smartbackoffice.provider.models.GeneratedTable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class TableService extends CrudService<Table> {

    public TableService() {
        super(null);
    }

    @Inject
    public TableService(EntityManager entityManager) {
        super(entityManager);
    }

    public GeneratedTable tablesGet() {
        return GeneratedTable.builder().name("Berlin").build();
    }
}
