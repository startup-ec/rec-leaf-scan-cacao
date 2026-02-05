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
public class TratamientoPorTipoDTO {
    private String tipoTratamiento;
    private Long cantidad;
    private BigDecimal costoTotal;

    public TratamientoPorTipoDTO(String tipoTratamiento, Long cantidad, double costoTotal) {
        this.tipoTratamiento = tipoTratamiento;
        this.cantidad = cantidad;
        this.costoTotal = BigDecimal.valueOf(costoTotal);
    }
}
