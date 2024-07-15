import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import './SignUp.css';
import { useState } from 'react';

const SignUp=() => {
  const [isLoading,setIsLoading]= useState(false)
  const [creds,setCreds] = useState([{
    email:"",
    password:""
  }]);

  const onSubmit = ()=>{
    
  }

//   const fetchSellers= async()=>{
//     setIsLoading(true)
//     try {
//         const res = await apiClient.get(`/api/v1/auth/register`,{creds})
//     .then((res)=>{
//             setSellers(res.data)
//             setIsLoading(false)}
//         )      
//     } catch (err) {
//             setIsLoading(false);
//             setErrors(err.message)   
//     } 
// }
  

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Sign Up</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent>
      <section className="align_center form_page">
        <form action="" className="authentication_form">
          <h2>Sign Up</h2>
          <div className="form_inputs">
            <div>
              <label htmlFor="first_name" className="">First Name</label>
              <input type="text" className="form_text_name" id='first_name' />
            </div>
            <div>
              <label htmlFor="last_name" className="">Last Name</label>
              <input type="text" className="form_text_name" id='last_name' />
            </div>
            <div>
              <label htmlFor="" className="">Email</label>
              <input type="email" className="form_text_name" />
            </div>
            <div>
              <label htmlFor="" className="">Password</label>
              <input type="text" className="form_text_name" />
            </div>
            <button type="submit" className="search_button form_submit"> Submit </button>
          </div>
        </form>
      </section>
      </IonContent>
    </IonPage>
  );
};

export default SignUp;
