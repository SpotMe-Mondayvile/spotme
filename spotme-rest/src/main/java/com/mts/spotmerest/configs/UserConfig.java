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
            User john = new User(
                    11231L,
                    "Magus",
                    25, GVB"male",
                    "black"
            );
        }
    }
}
