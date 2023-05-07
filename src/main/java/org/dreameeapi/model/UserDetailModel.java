package org.dreameeapi.model;

import org.dreameeapi.entity.Role;
import org.dreameeapi.entity.User;
import org.dreameeapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailModel implements UserDetails {
    private String username;
    private String password;
    private boolean enabled;
    private boolean locked;
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public UserDetailModel(User user, List<Role> roles) {
        username = user.getUsername();
        password = user.getPassword();
        enabled = user.getEnabled();
        locked = user.getLocked();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
