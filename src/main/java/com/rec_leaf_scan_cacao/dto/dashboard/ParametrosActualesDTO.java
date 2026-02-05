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
public class ParametrosActualesDTO {
    private BigDecimal temperatura;
    private BigDecimal humedadSuelo;
    private BigDecimal phSuelo;
    private BigDecimal horasSol;
    private LocalDateTime fechaMedicion;
}
