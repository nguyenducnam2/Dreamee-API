package org.dreameeapi.service;

import org.dreameeapi.entity.Role;
import org.dreameeapi.entity.User;
import org.dreameeapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class RoleService implements Service<Role> {
    @Autowired
    private RoleRepository roleRepository;

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
    public boolean exists(Role role) {
        return roleRepository.existsById(role.getId());
    }

    public List<Role> findByUser(User user) {
        return roleRepository.findByUser(user);
    }
}
