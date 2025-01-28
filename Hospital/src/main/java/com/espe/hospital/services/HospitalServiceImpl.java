package com.espe.hospital.services;

import com.espe.hospital.models.entities.Hospital;
import com.espe.hospital.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital agregarHospital(Hospital hospital) {
        if (hospital.getNombre() == null || hospital.getNombre().isEmpty()) {
            throw new RuntimeException("El nombre del hospital es obligatorio.");
        }
        if (hospital.getUbicacion() == null || hospital.getUbicacion().isEmpty()) {
            throw new RuntimeException("La ubicación del hospital es obligatoria.");
        }
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> listarHospitales() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital obtenerHospitalPorId(Long id) {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
    }

    @Override
    public Hospital actualizarHospital(Long id, Hospital hospitalDetalles) {
        Hospital hospitalExistente = obtenerHospitalPorId(id);

        hospitalExistente.setNombre(hospitalDetalles.getNombre());
        hospitalExistente.setUbicacion(hospitalDetalles.getUbicacion());

        return hospitalRepository.save(hospitalExistente);
    }

    @Override
    public void eliminarHospital(Long id) {
        Hospital hospital = obtenerHospitalPorId(id);
        hospitalRepository.delete(hospital);
    }
}
