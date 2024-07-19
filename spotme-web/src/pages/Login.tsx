import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import { useEffect, useRef,useState } from 'react';
import apiClient from '../utils/api-client';
import './Login.css';
import { Redirect } from 'react-router';

const Login=()=>{
  const [isLoading,setIsLoading]= useState(false)
  const [errors,setErrors]= useState("")
  const [cookies,setCookies] = useState([])
  const [token,setToken] = useState([])
  const passwordRef = useRef(null);
  const emailRef = useRef(null);
  const [creds,setCreds] = useState({
    email:"",
    password:""
  }); 


  const [isLoggedIn, setIsLoggedIn] = useState(false)

  const setStatus=  () => {
    localStorage.setItem('logged_user',"false") 

  }

  useEffect(() => {
    localStorage.setItem('logged_user', JSON.stringify(isLoggedIn));
    isLoggedIn? <Redirect to="/home"/>: <Redirect to="/login"/>
  }, [isLoggedIn]);

  const  handleLogin = ()=>{
    const currentCreds = {email:emailRef.current.value, password: passwordRef.current.value}
    console.log(currentCreds)
    setCreds(currentCreds)
    console.log("clicked")
    loginPost()
  }

  const loginPost= async()=>{
    console.log("Login Called")
    setIsLoading(true)
    try {
      console.log("trying api login")
        const res = await apiClient.client.post('/v1/auth/authenticate',creds)
.then((res: any)=>{
            console.log(res.data)
          }
        )
        apiClient.tokenSetter(token)
            setCookies([token])
            setIsLoading(false)
            setIsLoggedIn(true);
            console.log(apiClient)      
    } catch (err) {
            setIsLoading(false);
            setErrors(err.message)   
    } 
}

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Login</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent>
      <section className="align_center form_page">
        <form action="" className="authentication_form">
          <h2>Login Form</h2>
          <div className="form_inputs">
            <div>
              <label htmlFor="email_field" className="">Email</label>
              <input 
              type="email" 
              className="form_text_name"
              id='email_field' 
              ref={emailRef} />
            </div>
            <div>
              <label htmlFor="password_field" className="">Password</label>
              <input 
              type="password" 
              id='password_field' 
              ref ={passwordRef} 
              className="form_text_name"/>
              <button type='button' onClick={()=>passwordRef.current.type="password"}>Hide Password</button>
              <button type='button' onClick={()=>passwordRef.current.type="text"}>Show Password</button>
            </div>
            <button type="button" className="search_button form_submit" onClick={handleLogin}>Login</button>
            <div className="signup_button_container">
                       Need to make an account? <a href="/signup">Sign Up</a>
            </div>
          </div>
        </form>
      </section>
      </IonContent>
    </IonPage>
  );
};

export default Login;
