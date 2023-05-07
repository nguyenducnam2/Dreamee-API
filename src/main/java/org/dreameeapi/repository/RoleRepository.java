package org.dreameeapi.repository;

import org.dreameeapi.entity.Role;
import org.dreameeapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByUser(User user);
}
