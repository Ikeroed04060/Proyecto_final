<template>
    <CrudComponent
      ref="crudComponent"
      title="Ventas"
      :items="processedVentas"
      :current-item="currentVenta"
      @save="saveVenta"
      @delete="deleteVenta"
      @edit="editVenta"
    >
      <template #form>
        <ion-item>
          <ion-label position="floating">Cliente ID</ion-label>
          <ion-input v-model="currentVenta.clienteId"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="stacked">Productos</ion-label>
          <ion-select
            multiple
            v-model="selectedProductos"
            @ionChange="calcularTotal"
          >
            <ion-select-option
              v-for="producto in productos"
              :key="producto.id"
              :value="producto"
            >
              {{ producto.nombre }} - ${{ producto.precio }}
            </ion-select-option>
          </ion-select>
        </ion-item>
        <ion-item>
          <ion-label>Total: ${{ currentVenta.total.toFixed(2) }}</ion-label>
        </ion-item>
      </template>
    </CrudComponent>
  </template>
  
  ---
  
  ### Script
  
  ```vue
  <script>
  import CrudComponent from '@/components/CrudComponent.vue';
  import {
    getAllProductos,
  } from '@/services/producto-service'; // Servicio de productos
  import {
    getAllVentas,
    saveVenta,
    updateVenta,
    deleteVenta,
    findVentaById,
  } from '@/services/ventas-service'; // Servicio de ventas
  
  export default {
    name: 'VentasPage',
    components: { CrudComponent },
    data() {
      return {
        currentVenta: {
          id: null,
          clienteId: null,
          productos: [],
          total: 0,
          fecha: new Date(),
        },
        ventas: [],
        processedVentas: [],
        productos: [],
        selectedProductos: [],
      };
    },
    async mounted() {
      await this.loadVentas();
      await this.loadProductos();
    },
    methods: {
      async loadVentas() {
        try {
        const ventasData = await getAllVentas();
        this.processedVentas = ventasData.map((venta) => ({
            id: venta.id,  // Aquí asumo que 'venta.id' existe, ajusta si es necesario
            clienteId: venta.clienteId,
            productos: venta.detalleProductos.map(
                (detalle) => `${detalle.nombre} (x${detalle.cantidad})` // Ajustado para tu estructura
            ),
            total: venta.total,
            fecha: new Date(venta.fecha).toLocaleDateString(), // Asegura que 'fecha' esté en el formato correcto
        }));
        } catch (error) {
          console.error('Error al cargar ventas:', error);
          alert('Error al cargar la lista de ventas');
        }
      },
      async loadProductos() {
        try {
          this.productos = await getAllProductos();
        } catch (error) {
          console.error('Error al cargar productos:', error);
          alert('Error al cargar la lista de productos');
        }
      },
      calcularTotal() {
        const detalles = this.selectedProductos.map((producto) => ({
          productoId: producto.id,
          nombre: producto.nombre,
          precio: producto.precio,
          cantidad: 1, // Cantidad inicial
        }));
        const total = detalles.reduce(
          (acc, detalle) => acc + detalle.precio * detalle.cantidad,
          0
        );
        this.currentVenta.productos = detalles;
        this.currentVenta.total = total;
      },
      async saveVenta() {
        try {
          if (this.currentVenta.id) {
            await updateVenta(this.currentVenta, this.currentVenta.id);
          } else {
            await saveVenta(this.currentVenta);
          }
          await this.loadVentas();
          this.resetForm();
        } catch (error) {
          console.error('Error al guardar venta:', error);
          alert('Error al guardar la venta');
        }
      },
      async deleteVenta(id) {
        try {
          await deleteVenta(id);
          await this.loadVentas();
        } catch (error) {
          console.error('Error al eliminar venta:', error);
          alert('Error al eliminar la venta');
        }
      },
      async editVenta(id) {
        try {
          this.currentVenta = await findVentaById(id);
          this.selectedProductos = this.currentVenta.productos.map(
            (detalle) => this.productos.find((p) => p.id === detalle.productoId)
          );
          this.$refs.crudComponent.openEditModal();
        } catch (error) {
          console.error('Error al editar venta:', error);
          alert('Error al cargar los datos de la venta para edición');
        }
      },
      resetForm() {
        this.currentVenta = {
          id: null,
          clienteId: null,
          productos: [],
          total: 0,
          fecha: new Date(),
        };
        this.selectedProductos = [];
      },
    },
  };
  </script>
  