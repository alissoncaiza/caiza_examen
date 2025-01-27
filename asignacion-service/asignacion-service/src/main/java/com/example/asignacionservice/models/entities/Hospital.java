package com.example.asignacionservice.models.entities;

import lombok.Data;

@Data
public class Hospital {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
}
