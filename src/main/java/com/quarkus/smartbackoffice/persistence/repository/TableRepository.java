package com.quarkus.smartbackoffice.persistence.repository;


import com.quarkus.smartbackoffice.persistence.entity.Table;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TableRepository implements PanacheRepositoryBase<Table, Long> {
}
