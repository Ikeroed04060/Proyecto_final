package com.corhuila.Proyecto_final.IService;

import com.corhuila.Proyecto_final.Entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> findAll();                        // Listar todos los productos
    Optional<Producto> findById(String id);          // Buscar un producto por ID
    Producto save(Producto producto);                // Guardar o actualizar un producto
    Producto update(Producto producto);              // Actualizar un producto existente
    void deleteById(String id);                      // Eliminar un producto por ID
}

