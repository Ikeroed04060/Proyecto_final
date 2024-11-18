<template>
    <CrudComponent
      ref="crudComponent"
      title="Productos"
      :items="processedProductos"
      :current-item="currentItem"
      @save="saveProducto"
      @delete="deleteProducto"
      @edit="editProducto"
    >
      <template #form>
        <ion-item>
          <ion-label position="floating">Nombre</ion-label>
          <ion-input v-model="currentItem.nombre"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Descripción</ion-label>
          <ion-input v-model="currentItem.descripcion"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Stock</ion-label>
          <ion-input v-model="currentItem.stock"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Precio</ion-label>
          <ion-input v-model="currentItem.precio"></ion-input>
        </ion-item>
      </template>
    </CrudComponent>
  </template>
  
  <script>
  import CrudComponent from '@/components/CrudComponent.vue';
  import { getAllProductos, saveProducto, updateProducto, deleteProducto, findProductoById } from '@/services/producto-service';
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
    name: 'ProductoPage',
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
          descripcion : '',
          stock : '',
          precio: ''

        },
        productos: [],
        processedProductos: []
      };
    },
    async mounted() {
      await this.loadProductos();
    },
    methods: {
      async loadProductos() {
        try {
          const productosData = await getAllProductos();
          this.processedProductos = productosData.map((item) => ({
            id: item.id,
            nombre: item.nombre,
            descripcion: item.descripcion,          
            stock: item.stock,
            precio: item.precio,
          }));
        } catch (error) {
          console.error('Error al cargar productos:', error);
          alert('Error al cargar la lista de productos');
        }
      },
      async saveProducto() {
        try {
          if (this.currentItem.id) {
            await updateProducto(this.currentItem, this.currentItem.id);
          } else {
            await saveProducto(this.currentItem);
          }
          await this.loadProductos();
          this.resetForm();
        } catch (error) {
          console.error('Error al guardar Productos:', error);
          alert('Error al guardar el Productos');
        }
      },
      async deleteProducto(id) {
        try {
          await deleteProducto(id);
          await this.loadProductos();
        } catch (error) {
          console.error('Error al eliminar Productos:', error);
          alert('Error al eliminar el Productos');
        }
      },
      async editProducto(id) {
        try {
          console.log('ID del Productos a editar:', id);
          this.currentItem = await findProductoById(id);        
          this.$refs.crudComponent.openEditModal(); 
        } catch (error) {
          console.error(`Error al editar Productos ID ${id}:`, error);
          alert('Error al obtener los datos del Productos para edición');
        }
      },
      resetForm() {
        this.currentItem = { id: null, nombre: '', descripcion: '', stock: '', precio: '' };
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