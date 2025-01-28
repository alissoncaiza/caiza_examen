package com.espe.equipomedico.services;

import com.espe.equipomedico.models.entities.EquipoMedico;

import java.util.List;

public interface EquipoMedicoService {
    EquipoMedico agregarEquipoMedico(EquipoMedico equipoMedico);

    List<EquipoMedico> listarEquiposMedicos();

    EquipoMedico obtenerEquipoPorId(Long id);

    EquipoMedico actualizarEquipoMedico(Long id, EquipoMedico equipoDetalles);

    void eliminarEquipoMedico(Long id);
}
