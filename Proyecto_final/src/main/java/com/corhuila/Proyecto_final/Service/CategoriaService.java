package com.corhuila.Proyecto_final.Service;

import com.corhuila.Proyecto_final.Entity.Categoria;
import com.corhuila.Proyecto_final.IRepository.ICategoriaRepository;
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
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(String id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        if (categoria.getId() == null || !categoriaRepository.existsById(categoria.getId())) {
            throw new IllegalArgumentException("La categoría no existe");
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(String id) {
        categoriaRepository.deleteById(id);
    }
}



