package org.dreameeapi.reposiroty;

import org.dreameeapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}