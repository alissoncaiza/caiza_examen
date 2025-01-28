package com.espe.orquestador.models.entities;

import lombok.Data;

@Data
public class EquipoMedico {
    private Long id;
    private String nombre;
    private String tipo;
    private boolean disponible;
}
