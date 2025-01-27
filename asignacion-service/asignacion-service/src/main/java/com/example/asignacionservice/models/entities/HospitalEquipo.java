package com.example.asignacionservice.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hospital_equipo")
@Data
public class HospitalEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hospital_id", nullable = false)
    private Long hospitalId;

    @Column(name = "equipo_id", nullable = false)
    private Long equipoId;
}
