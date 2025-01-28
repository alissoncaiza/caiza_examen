package com.espe.orquestador.services;

import com.espe.orquestador.models.entities.Hospital;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "hospital-service",
        url = "http://localhost:8084/api/hospitales",
        configuration = com.espe.orquestador.config.FeignConfig.class
)
public interface HospitalFeignClient {
    @GetMapping("/{id}")
    Hospital obtenerHospitalPorId(@PathVariable Long id);
}
