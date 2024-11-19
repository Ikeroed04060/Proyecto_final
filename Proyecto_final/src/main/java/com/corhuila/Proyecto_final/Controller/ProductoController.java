package com.corhuila.Proyecto_final.Controller;


import com.corhuila.Proyecto_final.Entity.Producto;
import com.corhuila.Proyecto_final.IService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>>getAllProductos() {
        return ResponseEntity.ok(productoService.findAll());
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable String id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<?> createProducto(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = productoService.save(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }


    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable String id, @RequestBody Producto producto) {
        producto.setId(id);
        Producto productoActualizado = productoService.update(producto);
        return productoActualizado != null ? ResponseEntity.ok(productoActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable String id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
