package org.dreameeapi.config;

import org.dreameeapi.service.RoleService;
import org.dreameeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                .cors().disable()
                .authorizeHttpRequests().requestMatchers("/api/v1/user")
                .hasAnyAuthority("ADMIN", "MOD")
                .and()
                .httpBasic()
                .and()
                .logout().permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().permitAll();
        return http.build();
    }
}
