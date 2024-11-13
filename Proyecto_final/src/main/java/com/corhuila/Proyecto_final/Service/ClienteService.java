package com.corhuila.Proyecto_final.Service;

import com.corhuila.Proyecto_final.Entity.Cliente;
import com.corhuila.Proyecto_final.IRepository.IClienteRepository;
import com.corhuila.Proyecto_final.IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        if (cliente.getId() == null || !clienteRepository.existsById(cliente.getId())) {
            throw new IllegalArgumentException("El cliente no existe");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(String id) {
        clienteRepository.deleteById(id);}
}

