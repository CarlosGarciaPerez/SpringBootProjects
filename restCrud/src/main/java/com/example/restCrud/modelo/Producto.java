package com.example.restCrud.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table( name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name ="nombre",nullable = false)
    private String nombre;
    @Column(name ="descripcion",nullable = false)
    private String descripcion;
    @Column(name ="precio",nullable = false)
    private float precio;


}
