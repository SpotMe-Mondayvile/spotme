package com.mts.spotmerest.controllers;

import com.mts.spotmerest.auth.DataFilter;
import com.mts.spotmerest.models.Profile;
import com.mts.spotmerest.services.ProfileService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
@SecurityRequirement(name = "JWT")
@RequestMapping(path = "api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;
    private final DataFilter dataFilter;
    @Autowired
    public ProfileController(ProfileService profileService, DataFilter dataFilter){
        this.profileService= profileService;
        this.dataFilter= dataFilter;
    }

    @GetMapping
    public String printHello(){
        return "ProfileDTO Web Controller";
    }

    @GetMapping(path="/all")
    public List<Profile> getProfiles(Principal principal) throws Exception{
        // test if profileId is current principal or principal is an ADMIN
        Optional<Profile> profile = profileService.getProfileByEmail(principal.getName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return profileService.getProfiles(authentication);
    }

    //    @GetMapping(path="/emails")
    //    public List<String> getEmails(){
    //        return profileService.getEmails();
    //    }

    @GetMapping(path="/email/{uEmail}")
    public String getEmail(@PathVariable("uEmail")String email){
        return profileService.getEmail(email);
    }


    @GetMapping(path = "/{profile_id}")
    public Optional<Profile> getProfileInfo(@PathVariable("profile_id") Long profileId, Principal principal) throws Exception {
        // test if profileId is current principal or principal is an ADMIN
        Optional<Profile> out= Optional.empty();
        if(dataFilter.isProfile(principal,profileId)){
            out =profileService.getProfileByID(profileId);
        }
        return out;
    }


    @DeleteMapping(path= "/{ProfileId}")
    public void deleteProfile(@PathVariable("ProfileId") Long id){
        profileService.deleteProfile(id);
    }


    //// Admin controls

}
