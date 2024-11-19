import axios from 'axios';
import { API_BASE_URL } from './api-config';

const PRODUCTO_API_URL = `${API_BASE_URL}/productos`;

interface ProductoData{
    id : string;
    nombre : string;
    descripcion : string;
    stock : string;
    precio : string;
    categoriaId : string
    
}

export const getAllProductos = async (): Promise<any> => {
    try {
      const { data } = await axios.get(PRODUCTO_API_URL);
      return data;
    } catch (error) {
      console.error('Error al obtener productos:', error);
      throw error;
    }
  };
  
  export const findProductoById = async (id: number): Promise<any> => {
    try {
      const { data } = await axios.get(`${PRODUCTO_API_URL}/${id}`);
      return data;
    } catch (error) {
      console.error(`Error al obtener producto ID ${id}:`, error);
      throw error;
    }
  };
  
  export const saveProducto = async (productoData: ProductoData): Promise<any> => {
    try {
      const { data } = await axios.post(PRODUCTO_API_URL, productoData);
      return data;
    } catch (error) {
      console.error('Error al guardar Producto:', error);
      throw error;
    }
  };
  
  export const updateProducto = async (productoData: ProductoData, id: number): Promise<any> => {
    try {
      const { data } = await axios.put(`${PRODUCTO_API_URL}/${id}`, productoData);
      return data;
    } catch (error) {
      console.error(`Error al actualizar Producto ID ${id}:`, error);
      throw error;
    }
  };
  
  export const deleteProducto = async (id: number): Promise<any> => {
    try {
      const { data } = await axios.delete(`${PRODUCTO_API_URL}/${id}`);
      return data;
    } catch (error) {
      console.error(`Error al eliminar producto ID ${id}:`, error);
      throw error;
    }
  };