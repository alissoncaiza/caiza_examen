package com.espe.hospital.controllers;

import com.espe.hospital.models.entities.Hospital;
import com.espe.hospital.services.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitales")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<Hospital> agregarHospital(@Valid @RequestBody Hospital hospital) {
        return ResponseEntity.ok(hospitalService.agregarHospital(hospital));
    }

    @GetMapping
    public ResponseEntity<List<Hospital>> listarHospitales() {
        return ResponseEntity.ok(hospitalService.listarHospitales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> obtenerHospitalPorId(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalService.obtenerHospitalPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospital> actualizarHospital(@PathVariable Long id, @Valid @RequestBody Hospital hospitalDetalles) {
        return ResponseEntity.ok(hospitalService.actualizarHospital(id, hospitalDetalles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHospital(@PathVariable Long id) {
        hospitalService.eliminarHospital(id);
        return ResponseEntity.noContent().build();
    }
}
