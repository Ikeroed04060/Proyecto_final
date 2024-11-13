package com.corhuila.Proyecto_final.IRepository;

import com.corhuila.Proyecto_final.Entity.Proveedores;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedoresRepository extends MongoRepository<Proveedores, String> {
    // Aquí puedes agregar consultas personalizadas si lo necesitas
}