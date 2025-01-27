package com.example.equipomedicoservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class EquipoMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
}

