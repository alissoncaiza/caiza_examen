package com.example.asignacionservice.services;

import com.example.asignacionservice.models.entities.Hospital;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hospital-service", url = "http://localhost:8081/api/hospitales")
public interface HospitalFeignClient {
    @GetMapping("/{id}")
    Hospital getHospitalById(@PathVariable Long id);
}

