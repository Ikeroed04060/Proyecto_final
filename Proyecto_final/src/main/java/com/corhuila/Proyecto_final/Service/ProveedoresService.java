package com.corhuila.Proyecto_final.Service;


import com.corhuila.Proyecto_final.Entity.Proveedores;
import com.corhuila.Proyecto_final.IRepository.IProveedoresRepository;
import com.corhuila.Proyecto_final.IService.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresService implements IProveedoresService {

    @Autowired
    private IProveedoresRepository proveedoresRepository;

    @Override
    public List<Proveedores> findAll() {return proveedoresRepository.findAll();
    }

    @Override
    public Optional<Proveedores> findById(String id) {return proveedoresRepository.findById(id);
    }

    @Override
    public Proveedores save(Proveedores proveedores) {return proveedoresRepository.save(proveedores);
    }

    @Override
    public Proveedores update(Proveedores proveedores) {
        if (proveedores.getId() == null || !proveedoresRepository.existsById(proveedores.getId())) {
            throw new IllegalArgumentException("El proveedor no existe");
        }
        return proveedoresRepository.save(proveedores);
    }

    @Override
    public void deleteById(String id) {proveedoresRepository.deleteById(id);
    }

    @Override
    public Proveedores findByNit(String nit) {
        return proveedoresRepository.findByNit(nit);
    }

}

