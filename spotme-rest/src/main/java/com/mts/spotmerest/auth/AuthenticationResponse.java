package com.mts.spotmerest.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AuthenticationRequest{

    private String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public AuthenticationResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
