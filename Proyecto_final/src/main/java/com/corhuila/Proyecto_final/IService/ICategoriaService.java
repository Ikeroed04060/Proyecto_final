package com.corhuila.Proyecto_final.IService;

import com.corhuila.Proyecto_final.Entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<Categoria> findAll();                      // Listar todas las categorías
    Optional<Categoria> findById(String id);        // Buscar una categoría por ID
    Categoria save(Categoria categoria);            // Guardar o actualizar una categoría
    Categoria update(Categoria categoria);          // Actualizar una categoría existente
    void deleteById(String id);                     // Eliminar una categoría por ID
}

