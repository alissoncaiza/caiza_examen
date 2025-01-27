package com.example.asignacionservice.services;

import com.example.asignacionservice.models.entities.EquipoMedico;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "equipo-medico-service", url = "http://localhost:8082/api/equipos")
public interface EquipoMedicoFeignClient {
    @GetMapping("/{id}")
    EquipoMedico getEquipoById(@PathVariable Long id);
}

