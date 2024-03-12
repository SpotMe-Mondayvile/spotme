package com.mts.spotmerest.configs;

import com.mts.spotmerest.mappers.GymDAO;
import com.mts.spotmerest.mappers.MatchDAO;
import com.mts.spotmerest.models.Gym;
import com.mts.spotmerest.models.Match;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MatchConfig {

    @Bean
    CommandLineRunner commandLineRunnerMatch(MatchDAO matchDAO){
        return args -> {
            Match m1 = new Match(1L,2L,1L);
            Match m2 = new Match(2L,3L,1L);
            Match m3 = new Match(3L,1L,2L);
            Match m4 = new Match(4L,4L,1L);
            Match m5 = new Match(5L,3L,2L);
            matchDAO.saveAll(
                    List.of());
        };
    }
}
