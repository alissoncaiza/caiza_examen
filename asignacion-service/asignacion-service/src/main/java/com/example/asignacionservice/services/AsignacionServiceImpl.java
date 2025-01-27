package com.example.asignacionservice.services;

import com.example.asignacionservice.models.entities.HospitalEquipo;
import com.example.asignacionservice.repositories.HospitalEquipoRepository;
import com.example.asignacionservice.services.EquipoMedicoFeignClient;
import com.example.asignacionservice.services.HospitalFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionServiceImpl implements AsignacionService {

    private final HospitalEquipoRepository hospitalEquipoRepository;
    private final HospitalFeignClient hospitalFeignClient;
    private final EquipoMedicoFeignClient equipoMedicoFeignClient;

    @Override
    public HospitalEquipo asignarEquipo(Long hospitalId, Long equipoId) {
        // Validar existencia
        hospitalFeignClient.getHospitalById(hospitalId);
        equipoMedicoFeignClient.getEquipoById(equipoId);

        // Crear y guardar asignación
        HospitalEquipo hospitalEquipo = new HospitalEquipo();
        hospitalEquipo.setHospitalId(hospitalId);
        hospitalEquipo.setEquipoId(equipoId);
        return hospitalEquipoRepository.save(hospitalEquipo);
    }

    @Override
    public List<HospitalEquipo> getEquiposByHospital(Long hospitalId) {
        return hospitalEquipoRepository.findByHospitalId(hospitalId);
    }

    @Override
    public List<HospitalEquipo> getHospitalesByEquipo(Long equipoId) {
        return hospitalEquipoRepository.findByEquipoId(equipoId);
    }
}
