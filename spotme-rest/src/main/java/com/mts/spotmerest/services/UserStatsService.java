
package com.mts.spotmerest.services;

import com.mts.spotmerest.mappers.UserStatsDAO;
import com.mts.spotmerest.mappers.UserDAO;
import com.mts.spotmerest.models.Match;
import com.mts.spotmerest.models.UserStats;
import com.mts.spotmerest.models.User;
import com.mts.spotmerest.models.UserStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserStatsService {

    private final UserStatsDAO userStatsDAO;
    private final UserDAO userDAO;

    @Autowired
    public UserStatsService(UserStatsDAO userStatsDAO, UserDAO userDAO){
        this.userStatsDAO = userStatsDAO;
        this.userDAO= userDAO;
    }

    public List<UserStats> getUserStatss(){

        return userStatsDAO.findAll();
    }
    public Optional<UserStats> getUserStats(Long id){

        return userStatsDAO.findById(id);
    }
//
//    public List<Match> getUserStatsMatchesByID(Long userId){
//        Optional<UserStats> spot= spotDAO.findUserStatsByUserId(userId);
//        return spot.orElseThrow().getMatches();
//    }

    public List<Match> getUserStatsMatchesByUserID(Long spotID){
        Optional<UserStats> uStats= userStatsDAO.findById(spotID);
        return uStats.orElseThrow().getMatches();
    }
    public List<Optional<UserStats>> getUserStatsMatchesByUserEmail(String email){
        Optional<User> user = userDAO.findUserByUserEmail(email);
        List<Optional<UserStats>> uStats= userStatsDAO.findUserStatsByUserId(user.orElseThrow().getId());
        return uStats;
    }

    public void updateUserStats(Long id, UserStats spotIn){
        Optional<UserStats> uStats = userStatsDAO.findById(id);
        UserStats updated = uStats.orElseThrow().updateAttributes(spotIn);
        userStatsDAO.save(updated);
    }


    public void addNewUserStats(UserStats spot) {
        Optional<UserStats> userStatsById= userStatsDAO
                .findUserStatsById(spot.getId());
        if(userStatsById.isPresent()){
            throw new IllegalStateException("UserStats Already exists");
        }else{
            userStatsDAO.save(spot);
            System.out.println("UserStats Created");
        }
        userStatsDAO.save(spot);
    }

    public void deleteUserStats(Long id) {
        boolean exists = userStatsDAO.existsById(id);
        if(!exists){
            throw new IllegalStateException("UserStats with id "+ id+ "does not exist");
        }else{
            userStatsDAO.deleteById(id);
        }
    }

}