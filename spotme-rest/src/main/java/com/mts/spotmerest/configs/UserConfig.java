package com.mts.spotmerest.configs;

import com.mts.spotmerest.mappers.UserDOA;
import com.mts.spotmerest.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserDOA userDOA){
        return args -> {
            User magus = new User(
                    "Magus",
                    25,
                    "male",
                    "black"
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
            userDOA.saveAll(
                    List.of(magus,prince,joe));
        };
    }
}
