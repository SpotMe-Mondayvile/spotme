package com.mts.spotmerest.configs.starter_data;

import com.mts.spotmerest.mappers.MatchDAO;
import com.mts.spotmerest.mappers.SpotDAO;
import com.mts.spotmerest.mappers.UserDAO;
import com.mts.spotmerest.mappers.friendships.FriendRequestDAO;
import com.mts.spotmerest.mappers.friendships.UserFriendsDAO;
import com.mts.spotmerest.models.Match;
import com.mts.spotmerest.models.Spot;
import com.mts.spotmerest.models.friendships.Friend;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FriendConfig {

    @Bean
    CommandLineRunner commandLineRunnerFriend(UserFriendsDAO friendDAO,
                                             UserDAO userDAO){
        return args -> {
            Friend f1 = new Friend(1L,2L,true);
            Friend f2 = new Friend(1L,3L,true);
            Friend f3 = new Friend(1L,4L,true);
            Friend f4 = new Friend(2L,3L,true);
            Friend f5 = new Friend(2L,4L,true);
            Friend f6 = new Friend(3L,4L,true);


            friendDAO.saveAll(List.of(f1,f2,f3,f4,f5,f6));
        };
    }
}
