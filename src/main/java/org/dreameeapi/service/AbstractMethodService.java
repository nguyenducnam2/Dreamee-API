package org.dreameeapi.service;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractMethodService<T> implements SimpleMethodService<T> {
    protected JpaRepository<T, Integer> repository;

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public void remove(T t) {
        repository.delete(t);
    }

    @Override
    public void removeById(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean exists(T t) {
        List<T> list = findAll();
        for (T e : list) {
            if (e.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public abstract void setRepository(JpaRepository<T, Integer> repository);
}
