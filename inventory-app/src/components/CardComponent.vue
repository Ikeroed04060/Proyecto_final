<template>
    <ion-col size="12" size-md="4">
      <ion-card class="text-center">
        <ion-img
  v-if="imageSrc"
  :src="imageSrc"
  alt="Imagen"
  style="width: 150px; height: 100px; object-fit: cover; margin: 0 auto;"
/>
        <ion-card-header>
          <ion-card-title>{{ title }}</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <p>{{ description }}</p>
          <ion-button expand="block" @click="navigateToPage">{{ buttonText }}</ion-button>
        </ion-card-content>
      </ion-card>
    </ion-col>
  </template>
  
  <script>
  import {
    IonCol,
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardContent,
    IonButton,
    IonImg
  } from '@ionic/vue';
  
  export default {
    name: 'CardComponent',
    components: {
      IonCol,
      IonCard,
      IonCardHeader,
      IonCardTitle,
      IonCardContent,
      IonButton,
      IonImg
    },
    props: {
      title: {
        type: String,
        required: true
      },
      description: {
        type: String,
        required: true
      },
      buttonText: {
        type: String,
        required: true
      },
      pageLink: {
        type: String,
        required: true
      },
      imageSrc: {
      type: String,
      required: false // La imagen es opcional
    }
    },
    methods: {
      navigateToPage() {
        this.$router.push(this.pageLink);
      }
    },
    mounted() {
    console.log('Imagen:', this.imageSrc);
  }
  };
  </script>
  
  <style scoped>
  .text-center {
    text-align: center;
  }
  .card-image {
  width: 80px; /* Ajusta el ancho según tus necesidades */
  height: 80px; /* Ajusta el alto según tus necesidades */
  object-fit: cover; /* Asegura que la imagen se ajuste al contenedor */
  margin: 0 auto; /* Centrar la imagen */
  border-radius: 8px; /* Bordes redondeados opcionales */
}
  </style>  