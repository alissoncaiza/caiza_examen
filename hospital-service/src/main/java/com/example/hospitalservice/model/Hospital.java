package com.example.hospitalservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
}

