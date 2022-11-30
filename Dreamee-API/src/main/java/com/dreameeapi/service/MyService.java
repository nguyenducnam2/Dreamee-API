package com.dreameeapi.service;

import java.util.List;
import java.util.Optional;

public interface MyService<E> {
    List<E> findAll();

    Optional<E> findById(int id);

    E save(E e);

    void delete(E e);

    boolean exists(E e);
}
