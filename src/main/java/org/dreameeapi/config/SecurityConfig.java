package org.dreameeapi.config;

import org.dreameeapi.entity.User;
import org.dreameeapi.model.UserDetailModel;
import org.dreameeapi.service.RoleService;
import org.dreameeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .authorizeHttpRequests().anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .logout().logoutUrl("/logout").permitAll();
        return http.build();
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsManager() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        List<User> users = userService.findAll();
        for (User user : users) {
            userDetailsManager.createUser(new UserDetailModel(user, roleService.findByUser(user)));
        }
        return userDetailsManager;
    }
}
