import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import { useEffect, useRef,useState } from 'react';
import apiClient from '../utils/api-client';
import './Login.css';

const Login=()=>{
  const passwordRef = useRef(null)
  const [isLoading,setIsLoading]= useState(false)
  const [email,setEmail] =useState("") 
  const [errors,setErrors]= useState("")
  const [password,setPassword] =useState("") 
  const [creds,setCreds] = useState([{
    email:"",
    password:""
  }]); 


  useEffect(()=>{
      setCreds([{email:email,password:password}]);
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
        const res = await apiClient.post(`/api/v1/auth/authenticate`,{creds})
.then((res)=>{
            console.log(res.data)
            setIsLoading(false)}
        )      
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
