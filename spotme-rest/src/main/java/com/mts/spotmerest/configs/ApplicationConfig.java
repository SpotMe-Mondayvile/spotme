package com.mts.spotmerest.configs;

import com.mts.spotmerest.mappers.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

public class ApplicationConfig {

    private final UserDAO
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> null
    }
}
