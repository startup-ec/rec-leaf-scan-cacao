package com.rec_leaf_scan_cacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CultivoDTO {

    private Long id;
    private Long usuarioId;
    private String nombreCultivo;
    private String variedadCacao;
    private LocalDate fechaSiembra;
    private BigDecimal areaHectareas;
    private String ubicacionNombre;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private Integer altitud;
    private String tipoSuelo;
    private String sistemaRiego;
    private String estadoCultivo;
    private String notas;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    // Contadores opcionales de relaciones (sin cargar las colecciones completas)
    private Integer totalAnalisisImagenes;
    private Integer totalParametrosMonitoreo;
    private Integer totalAlertasMonitoreo;
    private Integer totalMedidasPreventivas;
    private Integer totalReportesGenerados;
}