package com.corhuila.Proyecto_final.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "ventas")
public class Ventas {

    @Id
    private String id;
    private String productoId;
    private int cantidadVendida;
    private double total;
    private Date fecha;
    private String clienteId; // Relación con la colección Clientes

}
