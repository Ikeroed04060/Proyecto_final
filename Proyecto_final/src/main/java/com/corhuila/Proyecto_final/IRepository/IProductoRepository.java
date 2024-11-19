package com.corhuila.Proyecto_final.IRepository;

import com.corhuila.Proyecto_final.Entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductoRepository extends MongoRepository<Producto, String> {

    Optional<Object> findByCodigo(String codigo);
}
