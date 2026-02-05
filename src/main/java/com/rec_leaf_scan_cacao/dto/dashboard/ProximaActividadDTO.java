package com.rec_leaf_scan_cacao.dto.dashboard;

import com.rec_leaf_scan_cacao.enums.GeneralEnums;
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
public class ProximaActividadDTO {
    private Long id;
    private String nombreActividad;
    private String descripcion;
    private LocalDateTime fechaProgramada;
    private GeneralEnums.Prioridad prioridad;
    private String cultivoNombre;
    private Long cultivoId;
    private BigDecimal costoReal;
    private String responsable;
    private Integer diasRestantes;
}