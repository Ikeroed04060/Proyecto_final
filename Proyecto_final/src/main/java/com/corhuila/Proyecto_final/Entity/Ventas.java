package com.corhuila.Proyecto_final.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "ventas")
public class Ventas {

    @Id
    private String id;
    private List<DetalleProducto> detalleProductos = new ArrayList<>();
    private double total;
    private Date fecha;
    private String clienteId; // Relación con la colección Clientes

}
