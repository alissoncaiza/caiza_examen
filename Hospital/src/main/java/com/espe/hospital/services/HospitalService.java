package com.espe.hospital.services;

import com.espe.hospital.models.entities.Hospital;

import java.util.List;

public interface HospitalService {
    Hospital agregarHospital(Hospital hospital);

    List<Hospital> listarHospitales();

    Hospital obtenerHospitalPorId(Long id);

    Hospital actualizarHospital(Long id, Hospital hospitalDetalles);

    void eliminarHospital(Long id);
}
