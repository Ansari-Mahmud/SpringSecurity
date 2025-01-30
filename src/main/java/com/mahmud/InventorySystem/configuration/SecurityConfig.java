package com.mahmud.InventorySystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}user1")
                .roles("user")
                .build();

        UserDetails sales = User.withUsername("seller")
                .password("{noop}seller1")
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(user, sales);
    }
}
