package org.dreameeapi.reposiroty;

import org.dreameeapi.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}