package org.dreameeapi.reposiroty;

import org.dreameeapi.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}