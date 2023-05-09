package org.dreameeapi.service;

import org.dreameeapi.entity.User;
import org.dreameeapi.model.UserDetailsModel;
import org.dreameeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userService.findByUsername(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Cannot find username : " + username);
        }
        return new UserDetailsModel(users.get(0), users.get(0).getRoles().stream().toList());
    }
}
