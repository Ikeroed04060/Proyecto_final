package com.corhuila.Proyecto_final.Service;

import com.corhuila.Proyecto_final.Entity.Ventas;
import com.corhuila.Proyecto_final.IRepository.IVentasRepository;
import com.corhuila.Proyecto_final.IService.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasService implements IVentasService {

    @Autowired
    private IVentasRepository ventasRepository;

    @Override
    public List<Ventas> findAll() {
        return ventasRepository.findAll();
    }

    @Override
    public Optional<Ventas> findById(String id) {
        return ventasRepository.findById(id);
    }

    @Override
    public Ventas save(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas update(Ventas ventas) {
        if (ventas.getId() == null || !ventasRepository.existsById(ventas.getId())) {
            throw new IllegalArgumentException("La venta no existe");
        }
        return ventasRepository.save(ventas);
    }

    @Override
    public void deleteById(String id) {
        ventasRepository.deleteById(id);}
}
