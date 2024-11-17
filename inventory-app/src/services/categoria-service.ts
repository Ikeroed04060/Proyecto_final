import axios from 'axios';
import { API_BASE_URL } from './api-config';

const CATEGORIA_API_URL = `${API_BASE_URL}/categorias`;

interface CategoriaData{
    nombre : string;
    descripcion : string;
}

export const getAllCategorias = async (): Promise<any> => {
    try {
      const { data } = await axios.get(CATEGORIA_API_URL);
      return data;
    } catch (error) {
      console.error('Error al obtener categorias:', error);
      throw error;
    }
  };
  
  export const findCategoriaById = async (id: number): Promise<any> => {
    try {
      const { data } = await axios.get(`${CATEGORIA_API_URL}/${id}`);
      return data;
    } catch (error) {
      console.error(`Error al obtener categoria ID ${id}:`, error);
      throw error;
    }
  };
  
  export const saveCategoria = async (categoriaData: CategoriaData): Promise<any> => {
    try {
      const { data } = await axios.post(CATEGORIA_API_URL, categoriaData);
      return data;
    } catch (error) {
      console.error('Error al guardar Categoria:', error);
      throw error;
    }
  };
  
  export const updateCategoria = async (categoriaData: CategoriaData, id: number): Promise<any> => {
    try {
      const { data } = await axios.put(`${CATEGORIA_API_URL}/${id}`, categoriaData);
      return data;
    } catch (error) {
      console.error(`Error al actualizar Categoria ID ${id}:`, error);
      throw error;
    }
  };
  
  export const deleteCategoria = async (id: number): Promise<any> => {
    try {
      const { data } = await axios.delete(`${CATEGORIA_API_URL}/${id}`);
      return data;
    } catch (error) {
      console.error(`Error al eliminar categoria ID ${id}:`, error);
      throw error;
    }
  };