package org.example.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // Updated method to configure HTTP Basic authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password("{noop}password") // {noop} specifies no password encoder
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

}