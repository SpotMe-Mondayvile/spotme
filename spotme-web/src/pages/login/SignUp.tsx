import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../../components/ExploreContainer';
import './SignUp.css';
import { useState } from 'react';
import { useForm } from 'react-hook-form';
import { signup } from '../../utils/services/userServices';

const SignUp=() => {
  const [isLoading,setIsLoading]= useState(false)
  const {
    register,
    handleSubmit,
    formState: {errors, ...formState}
  } = useForm()
  const [formError,setFormError]=useState("")


  const onSubmit =async (formData:any)=>{
    try{
      await signup(formData)
    }catch(err){
      if(err.response && err.response.status<500 && err.response.status>=400 ){
          setFormError(err.response.data.message)
      }
    }
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
              <label 
              htmlFor="first_name" 
              className="">
                First Name
                </label>
              <input 
              type="text" 
              className="form_text_name" 
              id='first_name' 
              {...register("firstname")}/>
            </div>
            <div>
              <label 
              htmlFor="last_name" 
              className="">
                Last Name
                </label>
              <input 
              type="text" 
              className="form_text_name" 
              id='last_name'
              {...register("lastname")}/>
            </div>
            <div>
              <label
               htmlFor="" 
               className="">
                Email</label>
              <input 
               type="email"
               className="form_text_name"
               id="email"
               {...register("email")} />
            </div>
            <div>
              <label
               htmlFor="" 
               className="">
                Password</label>
              <input
               type="text" 
               className="form_text_name" 
               id="password"
               {...register("password")}/>
            </div>
            <button type="button" className="search_button form_submit" onSubmit={handleSubmit((formData)=>onSubmit(formData))}> Submit </button>
          </div>
        </form>
      </section>
      </IonContent>
    </IonPage>
  );
};

export default SignUp;
