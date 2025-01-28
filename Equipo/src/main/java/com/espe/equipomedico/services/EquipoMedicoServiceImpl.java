package com.espe.equipomedico.services;

import com.espe.equipomedico.models.entities.EquipoMedico;
import com.espe.equipomedico.repositories.EquipoMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoMedicoServiceImpl implements EquipoMedicoService {

    @Autowired
    private EquipoMedicoRepository equipoMedicoRepository;

    @Override
    public EquipoMedico agregarEquipoMedico(EquipoMedico equipoMedico) {
        return equipoMedicoRepository.save(equipoMedico);
    }

    @Override
    public List<EquipoMedico> listarEquiposMedicos() {
        return equipoMedicoRepository.findAll();
    }

    @Override
    public EquipoMedico obtenerEquipoPorId(Long id) {
        return equipoMedicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo médico no encontrado"));
    }

    @Override
    public EquipoMedico actualizarEquipoMedico(Long id, EquipoMedico equipoDetalles) {
        EquipoMedico equipoExistente = obtenerEquipoPorId(id);

        equipoExistente.setNombre(equipoDetalles.getNombre());
        equipoExistente.setTipo(equipoDetalles.getTipo());
        equipoExistente.setDisponible(equipoDetalles.isDisponible());

        return equipoMedicoRepository.save(equipoExistente);
    }

    @Override
    public void eliminarEquipoMedico(Long id) {
        EquipoMedico equipo = obtenerEquipoPorId(id);
        equipoMedicoRepository.delete(equipo);
    }
}
