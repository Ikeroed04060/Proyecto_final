package com.corhuila.Proyecto_final.IService;

import com.corhuila.Proyecto_final.Entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    List<Categoria> getAllCategorias();

    Optional<Categoria> getCategoriaById(String id);

    Categoria createCategoria(Categoria categoria);

    Categoria updateCategoria(String id, Categoria categoria);

    void deleteCategoria(String id);

    Optional<Object> findById(String id);

    void deleteById(String id);
}
