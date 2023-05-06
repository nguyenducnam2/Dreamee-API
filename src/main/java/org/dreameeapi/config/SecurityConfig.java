package org.dreameeapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails defaultAdmin1 = User.builder()
                .username("default_admin")
                .password("$2a$12$QsmEsMMIWu4mJnjAGw/9jeS4HwumY5lJpPLwMHMA6bdeWO5MDpWzy")
                .roles("ADMIN")
                .build();
        UserDetails defaultUser1 = User.builder()
                .username("default_user")
                .password("$2a$12$QsmEsMMIWu4mJnjAGw/9jeS4HwumY5lJpPLwMHMA6bdeWO5MDpWzy")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(defaultAdmin1, defaultUser1);
    }
}
