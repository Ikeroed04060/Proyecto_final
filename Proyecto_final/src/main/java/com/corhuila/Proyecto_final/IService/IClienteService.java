package com.corhuila.Proyecto_final.IService;

import com.corhuila.Proyecto_final.Entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(String id);
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    void deleteById(String id);
}
