package com.example.equipomedicoservice.repository;

import com.example.equipomedicoservice.model.EquipoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoMedicoRepository extends JpaRepository<EquipoMedico, Long> {
}
