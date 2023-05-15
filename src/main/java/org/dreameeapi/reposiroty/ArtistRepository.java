package org.dreameeapi.reposiroty;

import org.dreameeapi.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}