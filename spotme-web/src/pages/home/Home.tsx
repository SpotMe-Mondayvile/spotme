import { IonButton, IonButtons, IonContent, IonHeader, IonMenu, IonMenuButton, IonPage, IonTitle, IonToolbar, useIonRouter } from '@ionic/react';
import ExploreContainer from '../../components/ExploreContainer';
import './Home.css';
import SideNav from '../../components/menu/SideNav';
import { useEffect } from 'react';
import { checkLogin } from './../../utils/userSession';
import NavMenu from '../sidenav/NavMenu';

const Home: React.FC = () => {
  const navigate = useIonRouter()
    
  useEffect(()=>{
    checkLogin(navigate)
  },[])

  return (
    <>
      {/* <IonMenu contentId="main-content">
        <IonHeader>
          <IonToolbar>
            <IonTitle>SpotMe</IonTitle>
          </IonToolbar>
        </IonHeader>
        <IonContent className="ion-padding">
        </IonContent>
      </IonMenu> */}
      <NavMenu/>
      <IonPage id="main-content">
        <IonHeader>
          <IonToolbar>
            <IonButtons slot="start">
              <IonMenuButton></IonMenuButton>
            </IonButtons>
            <IonTitle>SpotMe</IonTitle>
          </IonToolbar>
        </IonHeader>
        <IonContent className="ion-padding">Content</IonContent>
      </IonPage>
    </>
  );
};

export default Home;
