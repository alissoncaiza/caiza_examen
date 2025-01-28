package com.espe.equipomedico.repositories;

import com.espe.equipomedico.models.entities.EquipoMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoMedicoRepository extends JpaRepository<EquipoMedico, Long> {
}
