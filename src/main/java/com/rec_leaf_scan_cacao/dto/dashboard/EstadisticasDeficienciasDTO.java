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
public class EstadisticasDeficienciasDTO {
    private Long totalDeficienciasDetectadas;
    private List<DeficienciaFrecuenteDTO> deficienciasMasFrecuentes;
    private List<DeficienciaPorMesDTO> tendenciaMensual;
    private BigDecimal promedioConfianza;
}