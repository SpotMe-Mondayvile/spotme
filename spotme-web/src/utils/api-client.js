import axios from 'axios';

let a_token = "";

const axiosConfig={
    headers:{Authorization: 'Bearer '+ a_token},
    setToken: function(token){a_token= token}
}

const apiClient={
    a_token:"",
    client: axios.create({
                withCredentials: true,
                baseURL:"http://localhost:8080/api"
                // baseURL:"https://rest.spot-me-app.com/api"
            }, axiosConfig),
    tokenSetter:  function(token){
        this.a_token = token;
    }      

}



// apiClient.interceptors.request.use(config => {
//     // Assuming you have access to the cookie value
//     const authToken = 'your-auth-token';
   
//     // Set the cookie in the header
//     config.headers['Cookie'] = `auth_token=${authToken}`;
   
//     return config;
//    }, error => {
//     // Do something with request error
//     return Promise.reject(error);
//    });

export default apiClient;
