package com.corhuila.Proyecto_final.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
}