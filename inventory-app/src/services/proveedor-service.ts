import axios from 'axios';
import { API_BASE_URL } from './api-config';

const PROVEEDOR_API_URL = `${API_BASE_URL}/proveedores`;

interface ProveedorData{
    
    nombre : string;
    email : string;
    telefono : string;
    direccion : string
}


export const getAllProveedores = async (): Promise<any> => {
    try {
      const { data } = await axios.get(PROVEEDOR_API_URL);
      return data;
    } catch (error) {
      console.error('Error al obtener proveedores:', error);
      throw error;
    }
  };
  
  export const findProveedorById = async (id: number): Promise<any> => {
    try {
      const { data } = await axios.get(`${PROVEEDOR_API_URL}/${id}`);
      return data;
    } catch (error) {
      console.error(`Error al obtener proveedor ID ${id}:`, error);
      throw error;
    }
  };
  
  export const saveProveedor = async (proveedorData: ProveedorData): Promise<any> => {
    try {
      const { data } = await axios.post(PROVEEDOR_API_URL, proveedorData);
      return data;
    } catch (error) {
      console.error('Error al guardar Proveedor:', error);
      throw error;
    }
  };
  
  export const updateProveedor = async (proveedorData: ProveedorData, id: number): Promise<any> => {
    try {
      const { data } = await axios.put(`${PROVEEDOR_API_URL}/${id}`, proveedorData);
      return data;
    } catch (error) {
      console.error(`Error al actualizar proveedor ID ${id}:`, error);
      throw error;
    }
  };
  
  export const deleteProveedor = async (id: number): Promise<any> => {
    try {
      const { data } = await axios.delete(`${PROVEEDOR_API_URL}/${id}`);
      return data;
    } catch (error) {
      console.error(`Error al eliminar proveedor ID ${id}:`, error);
      throw error;
    }
  };