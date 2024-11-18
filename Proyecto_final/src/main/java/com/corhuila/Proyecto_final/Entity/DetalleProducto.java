package com.corhuila.Proyecto_final.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DetalleProducto {

    private String productoId; // ID del producto
    private String nombre;     // Nombre del producto (se obtiene automáticamente)
    private double precio;     // Precio del producto (se obtiene automáticamente)
    private int cantidad;      // Cantidad deseada (proporcionada por el usuario)
    private double subtotal;   // Subtotal = precio * cantidad (calculado automáticamente)
}
