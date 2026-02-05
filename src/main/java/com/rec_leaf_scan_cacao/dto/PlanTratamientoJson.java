package com.rec_leaf_scan_cacao.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanTratamientoJson implements Serializable {

    private String tratamiento;

    @JsonProperty("planAplicacion")
    private PlanAplicacion planAplicacion;

    @JsonProperty("tratamientoSuelo")
    private TratamientoSuelo tratamientoSuelo;

    private Seguimiento seguimiento;

    // Clases internas para la estructura JSON
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlanAplicacion implements Serializable {
        private String tipo;
        private String dosisPorLitro;
        private Integer volumenPorHectareaEstimado_L;
        private String dosisPorHectareaEstimada;
        private Integer frecuenciaDias;
        private Integer numeroAplicaciones;
        private Integer duracionTratamientoDias;
        private String horaRecomendada;
        private String precauciones;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TratamientoSuelo implements Serializable {
        private String accion;
        private String productoSugerido;
        private String dosisOrientativa;
        private String metodo;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Seguimiento implements Serializable {
        private String observableMejora;
        private String notasTecnico;
        private List<String> imagenesSeguimiento;
    }
}
