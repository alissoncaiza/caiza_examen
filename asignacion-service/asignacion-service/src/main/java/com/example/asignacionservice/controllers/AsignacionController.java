package com.example.asignacionservice.controllers;

import com.example.asignacionservice.models.entities.HospitalEquipo;
import com.example.asignacionservice.services.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
@RequiredArgsConstructor
public class AsignacionController {

    private final AsignacionService asignacionService;

    @PostMapping
    public HospitalEquipo asignarEquipo(
            @RequestParam("hospitalId") Long hospitalId,
            @RequestParam("equipoId") Long equipoId) {
        return asignacionService.asignarEquipo(hospitalId, equipoId);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<HospitalEquipo> getEquiposByHospital(@PathVariable Long hospitalId) {
        return asignacionService.getEquiposByHospital(hospitalId);
    }

    @GetMapping("/equipo/{equipoId}")
    public List<HospitalEquipo> getHospitalesByEquipo(@PathVariable Long equipoId) {
        return asignacionService.getHospitalesByEquipo(equipoId);
    }
}
