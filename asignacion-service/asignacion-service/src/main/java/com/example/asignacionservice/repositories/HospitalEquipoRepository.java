package com.example.asignacionservice.repositories;

import com.example.asignacionservice.models.entities.HospitalEquipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalEquipoRepository extends JpaRepository<HospitalEquipo, Long> {
    List<HospitalEquipo> findByHospitalId(Long hospitalId);
    List<HospitalEquipo> findByEquipoId(Long equipoId);
}
