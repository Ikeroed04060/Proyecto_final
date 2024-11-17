<template>
    <CrudComponent
      ref="crudComponent"
      title="Proveedor"
      :items="processedProveedor"
      :current-item="currentItem"
      @save="saveProveedor"
      @delete="deleteProveedor"
      @edit="editProveedor"
    >
      <template #form>
        <ion-item>
          <ion-label position="floating">Nombre</ion-label>
          <ion-input v-model="currentItem.nombre"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Contacto</ion-label>
          <ion-input v-model="currentItem.contacto"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Telefono</ion-label>
          <ion-input v-model="currentItem.telefono"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Dirección</ion-label>
          <ion-input v-model="currentItem.direccion"></ion-input>
        </ion-item>
      </template>
    </CrudComponent>
  </template>
  
  <script>
  import CrudComponent from '@/components/CrudComponent.vue';
  import { getAllProveedores, saveProveedor, updateProveedor, deleteProveedor, findProveedorById } from '@/services/proveedor-service';
  import {
    IonItem,
    IonLabel,
    IonInput,
    IonButton,
    IonModal,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardContent,
    IonIcon
  } from '@ionic/vue';
  
  export default {
    name: 'ProveedorPage',
    components: {
      CrudComponent,
      IonItem,
      IonLabel,
      IonInput,
      IonButton,
      IonModal,
      IonHeader,
      IonToolbar,
      IonTitle,
      IonContent,
      IonPage,
      IonCard,
      IonCardHeader,
      IonCardTitle,
      IonCardContent,
      IonIcon
    },
    data() {
      return {
        currentItem: {
          id: null,
          nombre: '',
          contacto : '',
          telefono : '',
          direccion: ''

        },
        proveedores: [],
        processedProveedor: []
      };
    },
    async mounted() {
      await this.loadProveedores();
    },
    methods: {
      async loadProveedores() {
        try {
          const proveedoresData = await getAllProveedores();
          this.processedProveedor = proveedoresData.map((item) => ({
            id: item.id,
            nombre: item.nombre,
            contacto: item.contacto,          
            telefono: item.telefono,
            direccion: item.direccion,
          }));
        } catch (error) {
          console.error('Error al cargar proveedores:', error);
          alert('Error al cargar la lista de proveedores');
        }
      },
      async saveProveedor() {
        try {
          if (this.currentItem.id) {
            await updateProveedor(this.currentItem, this.currentItem.id);
          } else {
            await saveProveedor(this.currentItem);
          }
          await this.loadProveedores();
          this.resetForm();
        } catch (error) {
          console.error('Error al guardar Proveedores:', error);
          alert('Error al guardar el Proveedor');
        }
      },
      async deleteProveedor(id) {
        try {
          await deleteProveedor(id);
          await this.loadProveedores();
        } catch (error) {
          console.error('Error al eliminar Proveedores:', error);
          alert('Error al eliminar el Proveedor');
        }
      },
      async editProveedor(id) {
        try {
          console.log('ID del Proveedor a editar:', id);
          this.currentItem = await findProveedorById(id);        
          this.$refs.crudComponent.openEditModal(); 
        } catch (error) {
          console.error(`Error al editar Proveedor ID ${id}:`, error);
          alert('Error al obtener los datos del Prroveedor para edición');
        }
      },
      resetForm() {
        this.currentItem = { id: null, nombre: '', contacto: '', telefono: '', direccion: '' };
      }
    }
  };
  </script>
  
  <style scoped>
  .button-group {
    display: flex;
    justify-content: flex-end;
    gap: 6px;
    margin-top: 8px;
  }
  
  ion-item {
    --padding-start: 16px;
    --inner-padding-top: 0px; 
    --inner-padding-bottom: 0px;
  }
  
  ion-label {
    line-height: 0.2; 
  }
  </style>