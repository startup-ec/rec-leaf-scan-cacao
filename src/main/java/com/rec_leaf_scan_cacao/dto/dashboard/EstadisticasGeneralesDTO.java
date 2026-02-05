package com.rec_leaf_scan_cacao.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasGeneralesDTO {
    private Long totalCultivos;
    private Long cultivosActivos;
    private BigDecimal areaTotal;
    private Long totalAnalisis;
    private Long analisisMesActual;
    private Long deficienciasDetectadas;
    private Long tratamientosActivos;
    private Long actividadesPendientes;
    private BigDecimal costoTotalTratamientos;
}