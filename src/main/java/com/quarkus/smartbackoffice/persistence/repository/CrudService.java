package com.quarkus.smartbackoffice.persistence.repository;

import com.quarkus.smartbackoffice.persistence.entity.BaseEntity;
import com.quarkus.smartbackoffice.persistence.entity.Table;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public abstract class CrudService<E extends BaseEntity> {

    protected final EntityManager entityManager;

    public E persist(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    public E update(E entity) {
        return entityManager.merge(entity);
    }

    public List<E> listAll() {
        final CriteriaQuery<E> query = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
        final Root<E> root = query.from(getEntityClass());
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Optional<E> getById(final Long id) {
        return Optional.ofNullable(entityManager.find(getEntityClass(), id));
    }

    public Optional<E> deleteById(final Long id) {
        final Optional<E> entity = getById(id);
        entity.ifPresent(e -> entityManager.remove(e));
        return entity;
    }
    protected abstract Class<E> getEntityClass();
}
