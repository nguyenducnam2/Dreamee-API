package org.dreameeapi.service;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.entity.User;
import org.dreameeapi.reposiroty.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements SimpleMethodService<User> {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }

    @Override
    public boolean exists(User user) {
        return userRepository.existsById(user.getId());
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
