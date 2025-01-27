package com.example.asignacionservice.services;

import com.example.asignacionservice.models.entities.HospitalEquipo;

import java.util.List;

public interface AsignacionService {
    HospitalEquipo asignarEquipo(Long hospitalId, Long equipoId);
    List<HospitalEquipo> getEquiposByHospital(Long hospitalId);
    List<HospitalEquipo> getHospitalesByEquipo(Long equipoId);
}
