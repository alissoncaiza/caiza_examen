package com.espe.equipomedico.controllers;

import com.espe.equipomedico.models.entities.EquipoMedico;
import com.espe.equipomedico.services.EquipoMedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos-medicos")
public class EquipoMedicoController {

    @Autowired
    private EquipoMedicoService equipoMedicoService;

    @PostMapping
    public ResponseEntity<EquipoMedico> agregarEquipoMedico(@Valid @RequestBody EquipoMedico equipoMedico) {
        return ResponseEntity.ok(equipoMedicoService.agregarEquipoMedico(equipoMedico));
    }

    @GetMapping
    public ResponseEntity<List<EquipoMedico>> listarEquiposMedicos() {
        return ResponseEntity.ok(equipoMedicoService.listarEquiposMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoMedico> obtenerEquipoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(equipoMedicoService.obtenerEquipoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoMedico> actualizarEquipoMedico(@PathVariable Long id, @Valid @RequestBody EquipoMedico equipoDetalles) {
        return ResponseEntity.ok(equipoMedicoService.actualizarEquipoMedico(id, equipoDetalles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipoMedico(@PathVariable Long id) {
        equipoMedicoService.eliminarEquipoMedico(id);
        return ResponseEntity.noContent().build();
    }
}
