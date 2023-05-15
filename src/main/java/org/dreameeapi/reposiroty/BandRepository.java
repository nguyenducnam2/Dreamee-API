package org.dreameeapi.reposiroty;

import org.dreameeapi.entity.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Integer> {
}