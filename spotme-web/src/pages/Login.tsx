import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, useIonRouter } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import { useEffect, useRef,useState } from 'react';
import {userLogin} from '../utils/services/userServices'
import './Login.css';
import { Redirect } from 'react-router';
import { useForm } from 'react-hook-form';
import { formToJSON } from 'axios';
import Home from './Home';

const Login=()=>{
  const [isLoading,setIsLoading]= useState(false)
  const [cookies,setCookies] = useState([])
  const [formError,setFormError]= useState("")
  const [token,setToken] = useState([])
  const {register, handleSubmit, formState: {errors,...formState}} = useForm()
  const [data,setData] = useState({})
  const navigate = useIonRouter()

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

  const onSubmit = async(formData:any)=>{
    try{
      const{data}= await userLogin(formData)
      localStorage.setItem('token',data.access_token);
      navigate.push('/home','root','replace')
    }catch(err){
      if(err.response && err.response.status<500 && err.response.status>=400 ){
         setFormError(err.response.data.message)
         console.log(err.response.data.message)
      }
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
        <form action="" className="authentication_form" onSubmit={handleSubmit((formData)=>{onSubmit(formData)})}>
          <h2>Login Form</h2>
          <div className="form_inputs">
            <div>
              <label htmlFor="email" className="">Email</label>
              <input 
              type="email" 
              className="form_text_name"
              id='email' 
              placeholder='Enter Email'
              {...register("email")}/>
            </div>
            <div>
              <label htmlFor="password_field" className="">Password</label>
              <input 
              type="password" 
              id='password_field' 
              {...register("password",{required:true, minLength:3})}
              className="form_text_name"
              placeholder='Enter Password'/>
              {errors.name?.type==="required" && <em className='form_error'>Please enter a valid password</em>}
              {errors.name?.type==="minLength" && <em className='form_error'>Password is too short</em>}
            </div>
            <button type="submit" className="search_button form_submit">Login</button>
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
