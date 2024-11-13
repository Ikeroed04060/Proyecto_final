package com.corhuila.Proyecto_final.IRepository;

import com.corhuila.Proyecto_final.Entity.Ventas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentasRepository extends MongoRepository<Ventas, String> {
}
