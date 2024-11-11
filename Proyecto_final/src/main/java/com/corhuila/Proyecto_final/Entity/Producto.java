package com.corhuila.Proyecto_final.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor  //Anotción de lombok que agrega contructor con argumentos
@NoArgsConstructor   //Anotación de lombok que agrega contructos sin argumentos o de sobrecarga
@Getter              //Anotación de lombok que agrega todos los Getters de los atributos de la entidad
@Setter              //Anotación de lombok que agrega todos los Getters de los atributos de la entidad

@Document(collection = "productos")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
    private String categoriaId; // Relación con la colección Categorías
}

