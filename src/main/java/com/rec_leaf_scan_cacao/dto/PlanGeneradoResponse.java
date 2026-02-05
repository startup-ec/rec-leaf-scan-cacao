package com.rec_leaf_scan_cacao.dto;

import com.rec_leaf_scan_cacao.enums.GeneralEnums;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class PlanGeneradoResponse {
    private Long planId;
    private String mensaje;
    private GeneralEnums.Prioridad prioridad;
    private BigDecimal costoEstimado;
    private Integer duracionDias;
    private LocalDate fechaInicioSugerida;
    private List<ActividadResumen> actividades;
    private String instrucciones;
}