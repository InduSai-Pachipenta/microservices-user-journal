package com.indusai.journal_service.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // ⚠️ Replace this with actual user lookup logic from DB if needed
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("{noop}admin123") // {noop} means no encoding for simplicity
                    .roles("ADMIN")
                    .build();
        } else if ("user".equals(username)) {
            return User.builder()
                    .username("user")
                    .password("{noop}user123")
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
