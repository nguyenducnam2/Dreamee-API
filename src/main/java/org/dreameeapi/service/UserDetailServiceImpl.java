package org.dreameeapi.service;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.entity.User;
import org.dreameeapi.model.UserDetailsModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Username not found :" + username);
        }
        return new UserDetailsModel(user.get());
    }
}
