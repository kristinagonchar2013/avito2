package com.amr.project.service.abstracts;

import com.amr.project.model.enums.EstablishedStatus;

import java.util.List;

public interface ReadWriteService<T, K> {

    T persist(final T entity);

    void update(final T entity);

    void delete(final T entity);

    void deleteByIdCascadeEnable(K id);

    void deleteByIdCascadeIgnore(K id);

    boolean existsById(K id);

    T findById(K id);

    List<T> findAll();

    List<T> findAllByStatus(EstablishedStatus establishedStatus);
}
