package com.espe.orquestador.controllers;

import com.espe.orquestador.models.entities.EquipoMedico;
import com.espe.orquestador.models.entities.Hospital;
import com.espe.orquestador.services.OrquestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orquestador")
public class OrquestadorController {

    @Autowired
    private OrquestadorService orquestadorService;

    @PostMapping("/asignar")
    public ResponseEntity<Void> asignarEquipoAHospital(@RequestParam Long hospitalId, @RequestParam Long equipoMedicoId) {
        orquestadorService.asignarEquipoAHospital(hospitalId, equipoMedicoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hospital/{hospitalId}/equipos")
    public ResponseEntity<List<EquipoMedico>> listarEquiposPorHospital(@PathVariable Long hospitalId) {
        return ResponseEntity.ok(orquestadorService.listarEquiposPorHospital(hospitalId));
    }

    @GetMapping("/equipo-medico/{equipoMedicoId}/hospitales")
    public ResponseEntity<List<Hospital>> listarHospitalesPorEquipo(@PathVariable Long equipoMedicoId) {
        return ResponseEntity.ok(orquestadorService.listarHospitalesPorEquipo(equipoMedicoId));
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Void> removerAsignacion(@RequestParam Long hospitalId, @RequestParam Long equipoMedicoId) {
        orquestadorService.removerAsignacion(hospitalId, equipoMedicoId);
        return ResponseEntity.noContent().build();
    }
}
