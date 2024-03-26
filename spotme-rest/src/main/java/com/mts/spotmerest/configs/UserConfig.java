package com.mts.spotmerest.configs;

import com.mts.spotmerest.mappers.UserDAO;
import com.mts.spotmerest.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserDAO userDAO){
        return args -> {
            User magus = new User(
                    "Magus",
                    25,
                    "male",
                    "black"
            );

            User toji = new User(
                    "Toji",
                    30,
                    "Zenin",
                    "asian"
            );

            User prince = new User(
                    "Prince",
                    23,
                    "male",
                    "black"
            );

            User joe = new User(
                    "Joe Mama",
                    22,
                    "male",
                    "white"
            );
            userDAO.saveAll(
                    List.of(magus,toji,prince,joe));
        };
    }
}
