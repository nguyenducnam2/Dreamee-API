package org.dreameeapi.service;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.entity.Role;
import org.dreameeapi.reposiroty.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements SimpleMethodService<Role> {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void remove(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public boolean exists(Role role) {
        return roleRepository.existsById(role.getId());
    }
}
