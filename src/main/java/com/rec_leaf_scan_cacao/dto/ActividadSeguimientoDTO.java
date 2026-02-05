package com.rec_leaf_scan_cacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ActividadSeguimientoDTO {
    private Long id;
    private LocalDateTime fechaProgramada;
    private String descripcion;
    private LocalDateTime fechaEjecutada;
    private String resultadoActividad;
    private BigDecimal costoReal;
    private String responsable;
    private Boolean recordatorioEnviado;
}
