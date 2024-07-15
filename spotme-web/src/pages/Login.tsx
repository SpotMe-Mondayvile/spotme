import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import { useEffect, useRef,useState } from 'react';
import apiClient from '../utils/api-client';
import './Login.css';
import { Redirect } from 'react-router';

const Login=()=>{
  const passwordRef = useRef(null)
  const [isLoading,setIsLoading]= useState(false)
  const [email,setEmail] =useState("") 
  const [errors,setErrors]= useState("")
  const [password,setPassword] =useState("") 
  const [cookies,setCookies] = useState([])
  const [token,setToken] = useState([])
  const [creds,setCreds] = useState({
    email:"",
    password:""
  }); 


  const [isLoggedIn, setIsLoggedIn] = useState({})

  const setStatus=  () => {
    localStorage.setItem('logged_user',"false") 

  }

  useEffect(() => {
    localStorage.setItem('logged_user', JSON.stringify(isLoggedIn));
    isLoggedIn? <Redirect to="/home"/>: <Redirect to="/login"/>
  }, [isLoggedIn]);



  useEffect(()=>{
      setCreds({email:email,password:password});
      console.log(email,password)
    }
    , [email,password]
  )
  const onSubmit = ()=>{
  
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
              <label htmlFor="email" id='email' className="">Email</label>
              <input 
              type="email" 
              className="form_text_name"
              id='email' onInput={(e:any) => setEmail(e.target.value)} />
            </div>
            <div>
              <label htmlFor="password" className="">Password</label>
              <input 
              type="password" 
              id='password' 
              //ref ={passwordRef} 
              className="form_text_name" onInput={(e:any) => setPassword(e.target.value)}/>
            </div>
            <button type="button" className="search_button form_submit" onClick={onSubmit}>Login</button>
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
