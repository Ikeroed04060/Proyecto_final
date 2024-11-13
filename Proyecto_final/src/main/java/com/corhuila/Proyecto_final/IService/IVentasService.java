package com.corhuila.Proyecto_final.IService;

import com.corhuila.Proyecto_final.Entity.Producto;
import com.corhuila.Proyecto_final.Entity.Ventas;

import java.util.List;
import java.util.Optional;

public interface IVentasService {
    List<Ventas> findAll();
    Optional<Ventas> findById(String id);
    Ventas save(Ventas ventas);
    Ventas update(Ventas ventas);
    void deleteById(String id);
}
