package com.espe.orquestador.services;

import com.espe.orquestador.models.entities.AsignacionEquipo;
import com.espe.orquestador.models.entities.EquipoMedico;
import com.espe.orquestador.models.entities.Hospital;
import com.espe.orquestador.repositories.AsignacionEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrquestadorServiceImpl implements OrquestadorService {

    @Autowired
    private AsignacionEquipoRepository asignacionEquipoRepository;

    @Autowired
    private HospitalFeignClient hospitalFeignClient;

    @Autowired
    private EquipoMedicoFeignClient equipoMedicoFeignClient;

    @Override
    public AsignacionEquipo asignarEquipoAHospital(Long hospitalId, Long equipoMedicoId) {
        // Validar si el hospital existe
        Hospital hospital;
        try {
            hospital = hospitalFeignClient.obtenerHospitalPorId(hospitalId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El hospital con ID " + hospitalId + " no está registrado.");
        }

        // Validar si el equipo médico existe
        EquipoMedico equipoMedico;
        try {
            equipoMedico = equipoMedicoFeignClient.obtenerEquipoPorId(equipoMedicoId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El equipo médico con ID " + equipoMedicoId + " no está registrado.");
        }

        // Crear la asignación
        AsignacionEquipo asignacion = new AsignacionEquipo();
        asignacion.setHospitalId(hospitalId);
        asignacion.setEquipoMedicoId(equipoMedicoId);
        return asignacionEquipoRepository.save(asignacion);
    }

    @Override
    public List<EquipoMedico> listarEquiposPorHospital(Long hospitalId) {
        // Validar si el hospital existe
        try {
            hospitalFeignClient.obtenerHospitalPorId(hospitalId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El hospital con ID " + hospitalId + " no está registrado.");
        }

        // Listar los equipos asignados al hospital
        List<AsignacionEquipo> asignaciones = asignacionEquipoRepository.findByHospitalId(hospitalId);
        return asignaciones.stream()
                .map(asignacion -> equipoMedicoFeignClient.obtenerEquipoPorId(asignacion.getEquipoMedicoId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Hospital> listarHospitalesPorEquipo(Long equipoMedicoId) {
        // Validar si el equipo médico existe
        try {
            equipoMedicoFeignClient.obtenerEquipoPorId(equipoMedicoId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El equipo médico con ID " + equipoMedicoId + " no está registrado.");
        }

        // Listar los hospitales que usan el equipo médico
        List<AsignacionEquipo> asignaciones = asignacionEquipoRepository.findByEquipoMedicoId(equipoMedicoId);
        return asignaciones.stream()
                .map(asignacion -> hospitalFeignClient.obtenerHospitalPorId(asignacion.getHospitalId()))
                .collect(Collectors.toList());
    }

    @Override
    public void removerAsignacion(Long hospitalId, Long equipoMedicoId) {
        AsignacionEquipo asignacion = asignacionEquipoRepository.findByHospitalId(hospitalId).stream()
                .filter(a -> a.getEquipoMedicoId().equals(equipoMedicoId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontró la asignación para el hospital con ID " + hospitalId +
                                " y el equipo médico con ID " + equipoMedicoId));
        asignacionEquipoRepository.delete(asignacion);
    }
}
