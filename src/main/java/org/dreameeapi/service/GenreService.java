package org.dreameeapi.service;

import org.dreameeapi.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends AbstractMethodService<Genre> implements SimpleMethodService<Genre> {
    @Autowired
    @Override
    public void setRepository(JpaRepository<Genre, Integer> repository) {
        this.repository = repository;
    }
}
