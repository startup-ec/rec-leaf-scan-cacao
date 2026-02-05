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
public class AnalisisRecienteDTO {
    private Long id;
    private LocalDateTime fechaAnalisis;
    private String nombreImagen;
    private Integer deficienciasDetectadas;
    private BigDecimal confianzaPromedio;
    private String estadoProcesamiento;
}