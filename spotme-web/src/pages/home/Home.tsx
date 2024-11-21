import { IonButton, IonButtons, IonContent, IonHeader, IonMenu, IonMenuButton, IonPage, IonTitle, IonToolbar, useIonRouter,
  IonInfiniteScroll,
  IonInfiniteScrollContent,
  IonList,
  IonItem,
  IonAvatar,
  IonLabel } from '@ionic/react';
import ExploreContainer from '../../components/ExploreContainer';
import './Home.css';
import SideNav from '../../components/menu/SideNav';
import { useEffect, useState } from 'react';
import { checkLogin } from './../../utils/userSession';
import NavMenu from '../sidenav/NavMenu';

const Home: React.FC = () => {
  const navigate = useIonRouter()
    
  useEffect(()=>{
    checkLogin(navigate)
  },[])
  
  const [items, setItems] = useState<string[]>([]);

  useEffect(() => {
    const newItems = [];
    for (let i = 1; i < 51; i++) {
      newItems.push(`Item ${items.length + i}`);
    }
    setItems([...items, ...newItems]);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

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
        <IonContent className="ion-padding">Content
        <IonList>
          {items.map((item, index) => (
            <IonItem key={item}>
              <IonAvatar slot="start">
                <img src={'https://picsum.photos/80/80?random=' + index} alt="avatar" />
              </IonAvatar>
              <IonLabel>{item}</IonLabel>
            </IonItem>
          ))}
      </IonList>
          <IonInfiniteScroll>
            <IonInfiniteScrollContent loadingText="Please wait..." loadingSpinner="bubbles">
              scroll
            </IonInfiniteScrollContent>
          </IonInfiniteScroll>
        </IonContent>
      </IonPage>
    </>
  );
};

export default Home;
