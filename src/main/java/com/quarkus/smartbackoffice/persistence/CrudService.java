package com.quarkus.smartbackoffice.persistence;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
public abstract class CrudService<E> {

    private final EntityManager entityManager;

    public E persist(E entity) {
        entityManager.persist(entity);
        return entity;
    }
}
