package com.corhuila.Proyecto_final.Service;



import com.corhuila.Proyecto_final.Entity.Categoria;
import com.corhuila.Proyecto_final.IRepository.ICategoriaRepository;
import com.corhuila.Proyecto_final.IRepository.IProductoRepository;
import com.corhuila.Proyecto_final.IService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {


    @Autowired
    private ICategoriaRepository categoriaRepository;


    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(String id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(String id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            categoria.setId(id);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    @Override
    public void deleteCategoria(String id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Optional<Object> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {

    }
}
