package org.dreameeapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class RegistrationSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors().and().csrf().disable().authorizeHttpRequests()
                .requestMatchers("/api/registration").permitAll().and().authorizeHttpRequests()
                .requestMatchers("/api/user/**").hasAnyAuthority("USER", "ADMIN")
                .and().authorizeHttpRequests().requestMatchers("/api/registration/**").permitAll()
                .and().formLogin().and().build();
    }
}
