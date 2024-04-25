package com.mts.spotmerest.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse{

    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String token) {
        this.access_token = token;
    }
}
