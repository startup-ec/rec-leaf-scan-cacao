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
public class DeficienciaActivaDTO {
    private Long resultadoId;
    private String nombreDeficiencia;
    private String nutrienteDeficiente;
    private String severidad;
    private BigDecimal confianza;
    private LocalDateTime fechaDeteccion;
    private Boolean tieneTratamiento;
}