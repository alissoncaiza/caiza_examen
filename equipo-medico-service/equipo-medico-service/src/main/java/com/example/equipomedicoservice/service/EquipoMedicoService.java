package com.example.equipomedicoservice.service;

import com.example.equipomedicoservice.model.EquipoMedico;
import com.example.equipomedicoservice.repository.EquipoMedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoMedicoService {

    private final EquipoMedicoRepository equipoMedicoRepository;

    public List<EquipoMedico> getAllEquipos() {
        return equipoMedicoRepository.findAll();
    }

    public EquipoMedico createEquipo(EquipoMedico equipoMedico) {
        return equipoMedicoRepository.save(equipoMedico);
    }

    public EquipoMedico getEquipoById(Long id) {
        return equipoMedicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }
}
