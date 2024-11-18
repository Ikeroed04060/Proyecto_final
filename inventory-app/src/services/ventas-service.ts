import axios from 'axios';
import { API_BASE_URL } from './api-config';

const VENTAS_API_URL = `${API_BASE_URL}/ventas`;

export interface ProductoDetalle {
    productoId: string;
    nombre: string;
    precio: number;
    cantidad: number;
  }
  
  export interface VentaData {
    id?: string; // Opcional, porque al crear la venta aún no tiene ID
    productos: ProductoDetalle[];
    total: number;
    fecha: Date;
    clienteId: string;
  }

export const getAllVentas = async (): Promise<any> =>{
  try {
    const { data } = await axios.get(VENTAS_API_URL);
    return data;
  } catch (error) {
    console.error('Error al obtener ventas:', error);
    throw error;
  }
};

export const findVentaById = async (id : number):Promise<any> =>{
  try {
    const { data } = await axios.get(`${VENTAS_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al obtener venta ID ${id}:`, error);
    throw error;
  }
};

export const saveVenta = async (ventaData : VentaData) :Promise<any> => {
  try {
    const { data } = await axios.post(VENTAS_API_URL, ventaData);
    return data;
  } catch (error) {
    console.error('Error al guardar venta:', error);
    throw error;
  }
};

export const updateVenta = async (ventaData: VentaData, id: number): Promise<any> => {
  try {
    const { data } = await axios.put(`${VENTAS_API_URL}/${id}`, ventaData);
    return data;
  } catch (error) {
    console.error(`Error al actualizar venta ID ${id}:`, error);
    throw error;
  }
};

export const deleteVenta = async (id:number): Promise<any> => {
  try {
    const { data } = await axios.delete(`${VENTAS_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al eliminar venta ID ${id}:`, error);
    throw error;
  }
};
