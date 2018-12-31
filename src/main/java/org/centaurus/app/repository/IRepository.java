package org.centaurus.app.repository;

import java.util.Set;

public interface IRepository<T, U> {
    T save(T t);

    T findById(U id);

    Boolean delete(T t);

    Set<T> findAll();

    T update(T t);
}
