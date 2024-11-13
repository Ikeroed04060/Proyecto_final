package com.corhuila.Proyecto_final.Controller;


import com.corhuila.Proyecto_final.Entity.Ventas;
import com.corhuila.Proyecto_final.IService.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ventas/")
public class VentasController {

    @Autowired
    private IVentasService ventasService;

    @GetMapping
    public ResponseEntity<List<Ventas>> getAllVentas() {
        return ResponseEntity.ok(ventasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> getVentasById(@PathVariable String id) {
        return ventasService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ventas> createVentas(@RequestBody Ventas ventas) {
        Ventas newVentas = ventasService.save(ventas);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVentas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> updateVentas(@PathVariable String id, @RequestBody Ventas ventas) {
        ventas.setId(id);
        Ventas ventasUpdate = ventasService.update(ventas);
        return ventasUpdate != null ? ResponseEntity.ok(ventasUpdate) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVentas(@PathVariable String id) {
        ventasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
