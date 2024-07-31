import { IonButton, IonContent, IonHeader, IonPage, IonTitle, IonToolbar, useIonRouter } from '@ionic/react';
import ExploreContainer from '../../components/ExploreContainer';
import './Friends.css';


const Friends = () => {
  const navigate = useIonRouter()

  const handleProfileClick=()=>{
    navigate.push("/Profile","root","replace")
    console.log("Pushed profile button")
    window.location.reload()
  }
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Friends</IonTitle>
          <IonButton onClick={handleProfileClick}>Profile</IonButton>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Friends</IonTitle>
          </IonToolbar>
        </IonHeader>
        <ExploreContainer name="Friends" />
      </IonContent>
    </IonPage>
  );
};

export default Friends;
