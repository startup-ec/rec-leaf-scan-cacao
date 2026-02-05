package com.rec_leaf_scan_cacao.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeficienciaPorMesDTO {
    private Integer mes;
    private Integer anio;
    private Long cantidad;
    private String nombreMes;
}