package org.dreameeapi.service;

import java.util.List;
import java.util.Optional;

public interface SimpleMethodService<T> {
    List<T> findAll();

    Optional<T> findById(int id);

    T save(T t);

    void remove(T t);

    boolean exists(T t);
}
