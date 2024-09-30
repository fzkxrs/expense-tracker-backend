package com.expenseapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF for simplicity
                .authorizeRequests(auth -> auth
                        .antMatchers("/auth/**").permitAll()  // Public access to auth routes
                        .anyRequest().authenticated()  // Protect all other routes
                )
                .httpBasic();  // Enable HTTP Basic authentication

        return http.build();
    }
}