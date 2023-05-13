package org.dreameeapi.config.security.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class JwtAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;
    private PasswordEncoder encoder;

    private UserDetails retrieveUser(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return userDetails;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        try {
            UserDetails userDetails = retrieveUser(username);
            if (!encoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())) {
                throw new Exception("Invalid Password");
            }
            return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public PasswordEncoder getEncoder() {
        return encoder;
    }
}
