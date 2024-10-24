import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, useIonRouter, IonItem, IonLabel, IonInput, IonButton, IonText } from '@ionic/react';
import './SignUp.css';
import { useState, useEffect, useRef } from 'react';
import { useForm } from 'react-hook-form';
import { signup } from '../../utils/services/userServices';
import { faCheck, faTimes, faInfoCircle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

//lets create a regex for valid characters
const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/;
const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;

const SignUp = () => {
  // useRef doesnt trigger re renders when used and can be used as mutable data
  const userRef = useRef();// for user input, allows us to set the focus on the useinput when component loads
  const errRef = useRef();// if we get the error we need to set the focus on it so it can be announced by screen reader

  const [user, setUser] = useState(''); // tied to the user input
  const [validName, setValidName] = useState(false); // tied to if name validates or not
  const [userFocus, setUserFocus] = useState(false); //tied to if we have focus on those input fields or not

  const [pwd, setPwd] = useState('');
  const [validPwd, setValidPwd] = useState(false);
  const [pwdFocus, setPwdFocus] = useState(false);

  const [matchPwd, setMatchPwd] = useState('');
  const [validMatch, setValidMatch] = useState(false);
  const [matchFocus, setMatchFocus] = useState(false);

  const [errMsg, setErrMsg] = useState('');
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    userRef.current.focus();
  }, []) // set the focus when component loads and set the focus to user name input

  useEffect(() => { 
    const result = USER_REGEX.test(user); // testing against the user regex state
    console.log(result); 
    console.log(user);
    setValidName(result);
  }, [user]) // anytime user changes it checks the validation of the field

  useEffect(() => { 
    const result = PWD_REGEX.test(pwd); // testing agains the password regex state
    console.log(result); 
    console.log(pwd);
    setValidPwd(result);
    const match = pwd === matchPwd; // need confrontation and then it will return boolean
    setValidMatch(match);
  }, [pwd, matchPwd]) // pwd and matchpwd to be in sync

  useEffect(() => {
    setErrMsg('');
  },[user, pwd, matchPwd]) // anytime one of these states are changed then clear error message once read because user is making changes

  /*
  const handleSubmit = async (e) => {
    e.preventDefault();
    // if button enabled with JS hack
    const v1 = USER_REGEX.test(user);// validate the info in the state of the user
    const v2 = PWD_REGEX.test(pwd);// validate the infor in the state of the password
    if (!v1 || !v2) {
      setErrMsg("Invalid Entry");
      return;
    }
      
    
  }
    */

  return (
    <section>
      <p ref={errRef} className={errMsg ? "errmsg" : 
        "offscreen"} aria-live="assertive">{errMsg}</p> 
      <h1>Sign Up</h1>
      <form onSubmit = {handleSubmit}>
        <label htmlFor="username"> 
          Username:
          <FontAwesomeIcon icon={faCheck} className={validName ? "valid" : "hide"} />
          <FontAwesomeIcon icon={faTimes} className={validName || !user ? "hide" : "invalid"} />
        </label>
        <input
          type="text"
          id="username"
          ref={userRef}
          autoComplete="off"
          onChange={(e) => setUser(e.target.value)}
          value={user}
          required
          ria-invalid={validName ? "false" : "true"}
          aria-describedby="uidnote"
          onFocus={() => setUserFocus(true)}
          onBlur={() => setUserFocus(false)}
        />
        <p id="uidnote" className={userFocus && user && !validName ? "instructions" : "offscreen"}>
          <FontAwesomeIcon icon={faInfoCircle} />
          4 to 24 characters.<br />
          Must begin with a letter.<br />
          Letters, numbers, underscores, hyphens allowed.
        </p>



        <label htmlFor="password">
          Password:
          <FontAwesomeIcon icon={faCheck} className={validPwd ? "valid" : "hide"} />
          <FontAwesomeIcon icon={faTimes} className={validPwd || !pwd ? "hide" : "invalid"} />
        </label>
        <input
          type="password"
          id="password"
          onChange={(e) => setPwd(e.target.value)}
          value={pwd}
          required
          aria-invalid={validPwd ? "false" : "true"}
          aria-describedby="pwdnote"
          onFocus={() => setPwdFocus(true)}
          onBlur={() => setPwdFocus(false)}
        />
        <p id="pwdnote" className={pwdFocus && !validPwd ? "instructions" : "offscreen"}>
          <FontAwesomeIcon icon={faInfoCircle} />
            8 to 24 characters.<br />
            Must include uppercase and lowercase letters, a number and a special character.<br />
            Allowed special characters: <span aria-label="exclamation mark">!</span> <span aria-label="at symbol">@</span> <span aria-label="hashtag">#</span> <span aria-label="dollar sign">$</span> <span aria-label="percent">%</span>
        </p>

        <label htmlFor="confirm_pwd">
          Confirm Password:
          <FontAwesomeIcon icon={faCheck} className={validMatch && matchPwd ? "valid" : "hide"} />
          <FontAwesomeIcon icon={faTimes} className={validMatch || !matchPwd ? "hide" : "invalid"} />
        </label>
        <input
          type="password"
          id="confirm_pwd"
          onChange={(e) => setMatchPwd(e.target.value)}
          value={matchPwd}
          required
          aria-invalid={validMatch ? "false" : "true"}
          aria-describedby="confirmnote"
          onFocus={() => setMatchFocus(true)}
          onBlur={() => setMatchFocus(false)}
        />
        <p id="pwdnote" className={pwdFocus && !validPwd ? "instructions" : "offscreen"}>
          <FontAwesomeIcon icon={faInfoCircle} />
          Must match the first password input field.
        </p>

        <button disabled = {!validName || !validPwd || !validMatch ? true : false}
        >Sign Up</button>
      </form>
      <p>
        Already registered?<br />
        <span className="line">
          {/*put react router link here*/}
          <a href="/login">Sign in</a>
        </span>
      </p>
    </section>
  )
};

export default SignUp;