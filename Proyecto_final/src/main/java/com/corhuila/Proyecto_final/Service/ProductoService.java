package com.corhuila.Proyecto_final.Service;

import com.corhuila.Proyecto_final.Entity.Producto;
import com.corhuila.Proyecto_final.IRepository.IProductoRepository;
import com.corhuila.Proyecto_final.IService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;


    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(String id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        if (producto.getId() == null || !productoRepository.existsById(producto.getId())) {
            throw new IllegalArgumentException("El producto no existe");
        }
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(String id) {
        productoRepository.deleteById(id);}
}
