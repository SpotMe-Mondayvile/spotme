import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, useIonRouter, IonItem, IonLabel, IonInput, IonButton, IonText } from '@ionic/react';
import './SignUp.css';
import { useState, useEffect, useRef } from 'react';
import { useForm } from 'react-hook-form';
import { signup } from '../../utils/services/userServices';


const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/;
const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;

const SignUp = () => {
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useIonRouter();
  const [formError, setFormError] = useState("");

  const userRef = useRef(null);
  const errRef = useRef(null);

  const [user, setUser] = useState('');
  const [validName, setValidName] = useState(false);
  const [userFocus, setUserFocus] = useState(false);

  const [pwd, setPwd] = useState('');
  const [validPwd, setValidPwd] = useState(false);
  const [pwdFocus, setPwdFocus] = useState(false);

  const [matchPwd, setMatchPwd] = useState('');
  const [validMatch, setValidMatch] = useState(false);
  const [matchFocus, setMatchFocus] = useState(false);

  const { register, handleSubmit } = useForm();

  useEffect(() => {
    userRef.current?.setFocus();
  }, [])

  useEffect(() => {
    setValidName(USER_REGEX.test(user));
  }, [user]);

  useEffect(() => {
    setValidPwd(PWD_REGEX.test(pwd));
    setValidMatch(pwd === matchPwd);
  }, [pwd, matchPwd]);

  useEffect(() => {
    setFormError('');
  }, [user, pwd, matchPwd]);

  const onSubmit = async (formData) => {
    if (!validName || !validPwd || !validMatch) {
      setFormError("Invalid Entry");
      return;
    }
    try {
      setIsLoading(true);
      const { data } = await signup(formData);
      localStorage.setItem('token', data.access_token);
      navigate.push('/Home', 'root', 'replace');
      window.location.reload();
    } catch (err) {
      setIsLoading(false);
      if (err.response && err.response.status >= 400 && err.response.status < 500) {
        setFormError(err.response.data.message);
      } else {
        setFormError("Registration Failed");
      }
      errRef.current?.focus();
    }
  };

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Sign Up</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent className="ion-padding">
        <section className="align_center form_page">
          <IonText ref={errRef} color="danger" className={formError ? "errmsg" : "offscreen"} aria-live="assertive">
            {formError}
          </IonText>
          <form className="authentication_form" onSubmit={handleSubmit(onSubmit)}>
            <h2>Sign Up</h2>
            <IonItem>
              <IonLabel position="floating">Username</IonLabel>
              <IonInput
                type="text"
                ref={userRef}
                value={user}
                onIonChange={(e) => setUser(e.detail.value)}
                required
                aria-invalid={validName ? "false" : "true"}
                aria-describedby="uidnote"
                onFocus={() => setUserFocus(true)}
                onBlur={() => setUserFocus(false)}
              />
              <IonText id="uidnote" color="medium" className={userFocus && user && !validName ? "instructions" : "offscreen"}>
                4 to 24 characters. Must begin with a letter. Letters, numbers, underscores, hyphens allowed.
              </IonText>
            </IonItem>

            <IonItem>
              <IonLabel position="floating">Password</IonLabel>
              <IonInput
                type="password"
                value={pwd}
                onIonChange={(e) => setPwd(e.detail.value)}
                required
                aria-invalid={validPwd ? "false" : "true"}
                aria-describedby="pwdnote"
                onFocus={() => setPwdFocus(true)}
                onBlur={() => setPwdFocus(false)}
              />
              <IonText id="pwdnote" color="medium" className={pwdFocus && !validPwd ? "instructions" : "offscreen"}>
                8 to 24 characters. Must include uppercase and lowercase letters, a number, and a special character. Allowed special characters: ! @ # $ %
              </IonText>
            </IonItem>

            <IonItem>
              <IonLabel position="floating">Confirm Password</IonLabel>
              <IonInput
                type="password"
                value={matchPwd}
                onIonChange={(e) => setMatchPwd(e.detail.value)}
                required
                aria-invalid={validMatch ? "false" : "true"}
                aria-describedby="confirmnote"
                onFocus={() => setMatchFocus(true)}
                onBlur={() => setMatchFocus(false)}
              />
              <IonText id="confirmnote" color="medium" className={matchFocus && !validMatch ? "instructions" : "offscreen"}>
                Must match the first password input field.
              </IonText>
            </IonItem>

            <IonButton expand="block" type="submit" disabled={!validName || !validPwd || !validMatch}>
              Sign Up
            </IonButton>
          </form>
        </section>
      </IonContent>
    </IonPage>
  );
};

export default SignUp;