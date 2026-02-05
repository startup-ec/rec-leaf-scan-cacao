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
public class DeficienciaFrecuenteDTO {
    private String nombreDeficiencia;
    private String nutrienteDeficiente;
    private Long cantidadDetecciones;
    private Long  porcentaje;

    public DeficienciaFrecuenteDTO(String nombreDeficiencia, String nutrienteDeficiente, Long cantidadDetecciones) {
        this.nombreDeficiencia = nombreDeficiencia;
        this.nutrienteDeficiente = nutrienteDeficiente;
        this.cantidadDetecciones = cantidadDetecciones;
    }
}