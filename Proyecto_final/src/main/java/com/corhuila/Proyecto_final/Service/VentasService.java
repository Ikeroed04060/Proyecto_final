package com.corhuila.Proyecto_final.Service;

import com.corhuila.Proyecto_final.Entity.DetalleProducto;
import com.corhuila.Proyecto_final.Entity.Producto;
import com.corhuila.Proyecto_final.Entity.Ventas;
import com.corhuila.Proyecto_final.IRepository.IProductoRepository;
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

    @Autowired
    private IProductoRepository productoRepository;

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

        double total = 0;

        // Procesar cada DetalleProducto
        for (DetalleProducto detalle : ventas.getDetalleProductos()) {
            // Buscar el producto en la base de datos por su ID
            Producto producto = productoRepository.findById(detalle.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto con ID " + detalle.getProductoId() + " no encontrado"));

            // Completar los valores del DetalleProducto
            detalle.setNombre(producto.getNombre());
            detalle.setPrecio(producto.getPrecio());
            detalle.setSubtotal(producto.getPrecio() * detalle.getCantidad());

            // Sumar al total
            total += detalle.getSubtotal();
        }

        // Asignar el total de la venta
        ventas.setTotal(total);

        // Guardar la venta en la base de datos
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
