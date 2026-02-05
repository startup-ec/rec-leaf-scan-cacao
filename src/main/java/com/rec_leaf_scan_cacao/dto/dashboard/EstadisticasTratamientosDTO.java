package com.rec_leaf_scan_cacao.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasTratamientosDTO {
    private Long totalTratamientos;
    private Long tratamientosCompletados;
    private Long tratamientosPendientes;
    private Long tratamientosEnProceso;
    private BigDecimal costoTotal;
    private BigDecimal costoPromedio;
    private List<TratamientoPorTipoDTO> tratamientosPorTipo;
}