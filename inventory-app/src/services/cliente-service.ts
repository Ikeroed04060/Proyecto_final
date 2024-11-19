import axios from 'axios';
import { API_BASE_URL } from './api-config';

const CLIENTE_API_URL = `${API_BASE_URL}/clientes`;

interface ClienteData {
    id : string;
    nombre: string;
    apellido: string;
    email: string;
    telefono: string;
    direccion : string;
}

export const getAllClientes = async (): Promise<any> => {
    try {
      const { data } = await axios.get(CLIENTE_API_URL);
      return data;
    } catch (error) {
      console.error('Error al obtener clientes:', error);
      throw error;
    }
  };

export const findClienteById = async (id: number): Promise<any> => {
    try {
      const { data } = await axios.get(`${CLIENTE_API_URL}/${id}`);
      return data;
    } catch (error) {
      console.error(`Error al obtener cliente ID ${id}:`, error);
      throw error;
    }
  };

export const saveCliente = async (clienteData: ClienteData): Promise<any> => {
    try {
      const { data } = await axios.post(CLIENTE_API_URL, clienteData);
      return data;
    } catch (error) {
      console.error('Error al guardar cliente:', error);
      throw error;
    }
  };

export const updateCliente = async (clienteData: ClienteData, id: number): Promise<any> => {
    try {
      const { data } = await axios.put(`${CLIENTE_API_URL}/${id}`, clienteData);
      return data;
    } catch (error) {
      console.error(`Error al actualizar cliente ID ${id}:`, error);
      throw error;
    }
  };

export const deleteCliente = async (id: number): Promise<any> => {
    try {
      const { data } = await axios.delete(`${CLIENTE_API_URL}/${id}`);
      return data;
    } catch (error) {
      console.error(`Error al eliminar cliente ID ${id}:`, error);
      throw error;
    }
  };
