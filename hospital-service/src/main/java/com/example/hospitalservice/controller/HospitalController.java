package com.example.hospitalservice.controller;

import com.example.hospitalservice.model.Hospital;
import com.example.hospitalservice.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitales")
public class HospitalController {
    private final HospitalRepository repository;

    public HospitalController(HospitalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Hospital getHospitalById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
    }

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return repository.save(hospital);
    }
}

