package com.corhuila.Proyecto_final.Controller;


import com.corhuila.Proyecto_final.Entity.Proveedores;
import com.corhuila.Proyecto_final.IService.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {


    @Autowired
    private IProveedoresService proveedoresService;

    @GetMapping
    public List<Proveedores> getAllProveedores (){ return proveedoresService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> getProveedoreById(@PathVariable String id) {
        Optional<Proveedores> proveedores = proveedoresService.findById(id);
        return proveedores.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proveedores> createProveedores(@RequestBody Proveedores proveedores) {
        Proveedores createdProveedores = proveedoresService.save(proveedores);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProveedores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> updateProveedores(@PathVariable String id, @RequestBody Proveedores proveedores) {
        proveedores.setId(id);
        Proveedores updatedProveedores = proveedoresService.update(proveedores);
        return updatedProveedores != null ? ResponseEntity.ok(updatedProveedores) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedores(@PathVariable String id) {
        proveedoresService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

