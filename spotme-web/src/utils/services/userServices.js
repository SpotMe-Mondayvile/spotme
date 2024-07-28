import apiClient from "../api-client";

export function signup(user){
    return apiClient.post('/v1/auth/register',user)
}

export function userLogin(creds){
    return apiClient.post('/v1/auth/authenticate',creds)
}