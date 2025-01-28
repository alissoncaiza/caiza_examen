package com.espe.orquestador.repositories;

import com.espe.orquestador.models.entities.AsignacionEquipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignacionEquipoRepository extends JpaRepository<AsignacionEquipo, Long> {
    List<AsignacionEquipo> findByHospitalId(Long hospitalId);

    List<AsignacionEquipo> findByEquipoMedicoId(Long equipoMedicoId);
}
