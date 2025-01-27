package com.example.equipomedicoservice.controller;

import com.example.equipomedicoservice.model.EquipoMedico;
import com.example.equipomedicoservice.repository.EquipoMedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class EquipoMedicoController {

    private final EquipoMedicoRepository repository;

    @GetMapping("/{id}")
    public EquipoMedico getEquipoById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Equipo Médico no encontrado"));
    }

    @PostMapping
    public EquipoMedico createEquipo(@RequestBody EquipoMedico equipoMedico) {
        return repository.save(equipoMedico);
    }
}
