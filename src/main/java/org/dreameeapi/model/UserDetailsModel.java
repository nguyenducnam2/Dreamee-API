package org.dreameeapi.model;

import lombok.NoArgsConstructor;
import org.dreameeapi.entity.User;
import org.dreameeapi.service.JwtService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class UserDetailsModel implements UserDetails {
    private String username;
    private String password;
    private boolean enabled;
    private boolean locked;
    private List<GrantedAuthority> authorities;
    private long expired;

    public UserDetailsModel(User user) {
        username = user.getUsername();
        password = user.getPassword();
        enabled = user.getEnabled();
        locked = user.getLocked();
        authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        setExpired(authorities);
    }

    private void setExpired(List<GrantedAuthority> authorities) {
        GrantedAuthority role = authorities.get(0);
        switch (role.getAuthority()) {
            case "ADMIN" -> expired = JwtService.EXPIRE_10_YEAR;
            case "MOD" -> expired = JwtService.EXPIRE_1_YEAR;
            case "DEV" -> expired = JwtService.EXPIRE_10_HOUR;
            default -> expired = JwtService.EXPIRE_1_HOUR;
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
        return enabled;
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

    public long getExpired() {
        return expired;
    }
}
