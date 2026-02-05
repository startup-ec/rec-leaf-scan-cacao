package com.rec_leaf_scan_cacao.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoActivoDTO {
    private Long planId;
    private String nombreTratamiento;
    private String tipoTratamiento;
    private String estado;
    private String prioridad;
    private LocalDateTime fechaInicio;
    private Integer duracionDias;
    private BigDecimal progreso;
    private Integer actividadesPendientes;
}