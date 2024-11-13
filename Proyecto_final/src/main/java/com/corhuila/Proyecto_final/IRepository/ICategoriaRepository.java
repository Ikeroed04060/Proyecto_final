package com.corhuila.Proyecto_final.IRepository;

import com.corhuila.Proyecto_final.Entity.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends MongoRepository<Categoria, String> {
    // Aquí puedes agregar consultas personalizadas si lo necesitas
}
