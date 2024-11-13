package com.corhuila.Proyecto_final.IRepository;

import com.corhuila.Proyecto_final.Entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String> {
}
