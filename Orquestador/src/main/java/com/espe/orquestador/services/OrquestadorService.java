package com.espe.orquestador.services;

import com.espe.orquestador.models.entities.AsignacionEquipo;
import com.espe.orquestador.models.entities.EquipoMedico;
import com.espe.orquestador.models.entities.Hospital;

import java.util.List;

public interface OrquestadorService {
    AsignacionEquipo asignarEquipoAHospital(Long hospitalId, Long equipoMedicoId);

    List<EquipoMedico> listarEquiposPorHospital(Long hospitalId);

    List<Hospital> listarHospitalesPorEquipo(Long equipoMedicoId);

    void removerAsignacion(Long hospitalId, Long equipoMedicoId);
}
