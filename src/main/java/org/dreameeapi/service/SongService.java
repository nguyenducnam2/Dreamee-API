package org.dreameeapi.service;

import org.dreameeapi.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SongService extends AbstractMethodService<Song> implements SimpleMethodService<Song> {

    @Autowired
    @Override
    public void setRepository(JpaRepository<Song, Integer> repository) {
        this.repository = repository;
    }
}
