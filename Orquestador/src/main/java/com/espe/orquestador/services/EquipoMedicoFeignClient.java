package com.espe.orquestador.services;

import com.espe.orquestador.models.entities.EquipoMedico;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "equipo-medico-service",
        url = "http://localhost:8085/api/equipos-medicos",
        configuration = com.espe.orquestador.config.FeignConfig.class
)
public interface EquipoMedicoFeignClient {
    @GetMapping("/{id}")
    EquipoMedico obtenerEquipoPorId(@PathVariable Long id);
}
