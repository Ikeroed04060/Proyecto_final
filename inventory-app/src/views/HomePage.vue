

<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Gestión de ventas</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid>
        <ion-row>
          <CardComponent
            title="Producto"
            description="Administrar productos registrados en el sistema."
            buttonText="Gestionar Productos"
            pageLink="/productos"
            imageSrc="./assets/images/producto.jpg"
          />
          <CardComponent
            title="Proveedor"
            description="Administrar proveedores disponibles en el sistema."
            buttonText="Gestionar Proveedores"
            pageLink="/proveedores"
            imageSrc="./assets/images/prro.jpg"
          />
          <CardComponent
            title="Categoria"
            description="Administrar las categorias."
            buttonText="Gestionar categorias"
            pageLink="/categoria"
            imageSrc="./assets/images/cate.jpg"
          />
          <CardComponent
            title="Ventas"
            description="Administrar las Ventas."
            buttonText="Gestionar ventas"
            pageLink="/ventas"
          />
          <CardComponent
            title="Clientes"
            description="Administrar Clientes."
            buttonText="Gestionar clientes"
            pageLink="/clientes"
          />
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonRow } from '@ionic/vue';
import CardComponent from '@/components/CardComponent.vue';

export default {
  name: 'HomePage',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonGrid,
    IonRow,
    CardComponent
  }
};
</script>