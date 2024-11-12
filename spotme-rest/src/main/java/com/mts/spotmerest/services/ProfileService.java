package com.mts.spotmerest.services;

import com.mts.spotmerest.mappers.ProfileDAO;
import com.mts.spotmerest.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private final ProfileDAO profileDAO;


    @Autowired
    public ProfileService(ProfileDAO profileDAO){
        this.profileDAO = profileDAO;
    }

    public List<Profile> getProfiles(Authentication auth) throws Exception{
        List<Profile> profiles= new ArrayList<>();
        if(hasRole("ADMIN",auth)){
            profiles = profileDAO.findAll();
        }
        return profiles;
    }

    public Optional<Profile> getProfileByEmail(String usrEmail){
        return profileDAO.findProfileByProfileEmail(usrEmail);
    }

    public Optional<Profile> getProfileByID(Long id){
        String idS = id.toString();
        return profileDAO.findById(id);
    }

    public List<String> getEmails(Authentication auth) throws Exception {
        List<String> emails = new ArrayList<>();
        List<Profile> profile = getProfiles(auth);
        for(int i=0; i<emails.size();i++){
            String temp = profile.get(i).getEmail();
            emails.add(temp);
        }
        return emails;
    }

    public void addNewProfile(Profile profile) {
        Optional<Profile> profileByProfileName= profileDAO
                .findProfileByProfileName(profile.getProfilename());
        if(profileByProfileName.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        profileDAO.save(profile);
    }

    public void deleteProfile(Long id) {
        boolean exists =profileDAO.existsById(id);
        if(!exists){
            throw new IllegalStateException("ProfileDTO with id "+ id+ "does not exist");
        }else{
            profileDAO.deleteById(id);
        }
    }

    public String getEmail(String email) {
        Optional<Profile> profileByProfileEmail= profileDAO
                .findProfileByProfileEmail(email);
        if(profileByProfileEmail.isPresent()){
            System.out.println("Email found");
        }else{
            System.out.println("Could not find email");
        }
        return profileByProfileEmail.orElseThrow().getEmail();
    }

    public String getPhoneNumber(String email){
        return getProfileByEmail(email).orElseThrow().getPhoneNumber();
    }
    public String getFirstName(String email){
        return getProfileByEmail(email).orElseThrow().getPhoneNumber();
    }
    public Boolean getStatus(String email){
        return getProfileByEmail(email).orElseThrow().isEnabled();
    }


    private boolean hasRole(String role, Authentication authentication) {

        boolean hasProfileRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));
        return hasProfileRole;
    }


}
