package com.espe.orquestador.models.entities;

import jakarta.persistence.*;

@Entity
public class AsignacionEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long hospitalId;

    @Column(nullable = false)
    private Long equipoMedicoId;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getEquipoMedicoId() {
        return equipoMedicoId;
    }

    public void setEquipoMedicoId(Long equipoMedicoId) {
        this.equipoMedicoId = equipoMedicoId;
    }
}
