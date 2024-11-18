<template>
    <CrudComponent
      ref="crudComponent"
      title="Categorias"
      :items="processedCategorias"
      :current-item="currentItem"
      @save="saveCategoria"
      @delete="deleteCategoria"
      @edit="editCategoria"
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
      </template>
    </CrudComponent>
  </template>
  
  <script>
  import CrudComponent from '@/components/CrudComponent.vue';
  import { getAllCategorias, saveCategoria, updateCategoria, deleteCategoria, findCategoriaById } from '@/services/categoria-service';
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
    name: 'CategoriaPage',
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
          descripcion : ''
        },
        categorias: [],
        processedCategorias: []
      };
    },
    async mounted() {
      await this.loadCategorias();
    },
    methods: {
      async loadCategorias() {
        try {
          const categoriasData = await getAllCategorias();
          this.processedCategorias = categoriasData.map((item) => ({
            id: item.id,
            nombre: item.nombre,
            descripcion: item.descripcion,          
          }));
        } catch (error) {
          console.error('Error al cargar categorias:', error);
          alert('Error al cargar la lista de categorias');
        }
      },
      async saveCategoria() {
        try {
          if (this.currentItem.id) {
            await updateCategoria(this.currentItem, this.currentItem.id);
          } else {
            await saveCategoria(this.currentItem);
          }
          await this.loadCategorias();
          this.resetForm();
        } catch (error) {
          console.error('Error al guardar Categorias:', error);
          alert('Error al guardar el Categorias');
        }
      },
      async deleteCategoria(id) {
        try {
          await deleteCategoria(id);
          await this.loadCategorias();
        } catch (error) {
          console.error('Error al eliminar Categorias:', error);
          alert('Error al eliminar el Categorias');
        }
      },
      async editCategoria(id) {
        try {
          console.log('ID del Categorias a editar:', id);
          this.currentItem = await findCategoriaById(id);        
          this.$refs.crudComponent.openEditModal(); 
        } catch (error) {
          console.error(`Error al editar Categorias ID ${id}:`, error);
          alert('Error al obtener los datos del Categorias para edición');
        }
      },
      resetForm() {
        this.currentItem = { nombre: '', descripcion: ''};
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