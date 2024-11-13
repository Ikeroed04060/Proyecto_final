package com.corhuila.Proyecto_final.IService;

import com.corhuila.Proyecto_final.Entity.Proveedores;

import java.util.List;
import java.util.Optional;

public interface IProveedoresService {
    List<Proveedores> findAll();                      // Listar todas los proveedores
    Optional<Proveedores> findById(String id);        // Buscar un proveedor por ID
    Proveedores save (Proveedores proveedores);            // Guardar o actualizar un proveedor
    Proveedores update(Proveedores proveedores);          // Actualizar un proveedor existente
    void deleteById(String id);                     // Eliminar un proveedor por ID
}