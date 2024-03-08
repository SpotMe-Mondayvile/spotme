package com.mts.spotmerest.configs;

import com.mts.spotmerest.mappers.UserDAO;
import com.mts.spotmerest.models.Role;
import com.mts.spotmerest.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(UserDAO userDAO){
//
//
//        return args -> {
//            User test= new User("badmin",
//                    "asdfasd",
//                    "badmin@fake.com",
//                    "badmin_password",
//                    Role.USER
//            );
//            test.setPassword("password");
//            userDAO.saveAll(
//                    List.of(test));
//        };
//    }
}
