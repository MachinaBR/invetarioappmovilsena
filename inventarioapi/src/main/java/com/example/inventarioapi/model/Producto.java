package com.example.inventarioapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String categoria;
    private Integer cantidad;
    private Double precio;
    private String proveedor;
    private String imagenUri; // Opcional
}