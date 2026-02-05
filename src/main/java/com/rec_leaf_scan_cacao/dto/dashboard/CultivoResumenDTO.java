package com.rec_leaf_scan_cacao.dto.dashboard;

import com.rec_leaf_scan_cacao.entity.Cultivo;
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
public class CultivoResumenDTO {
    private Long id;
    private String nombreCultivo;
    private String variedadCacao;
    private BigDecimal areaHectareas;
    private Cultivo.EstadoCultivo estadoCultivo;
    private String ubicacionNombre;
    private Integer analisisRealizados;
    private Integer deficienciasActivas;
    private LocalDateTime ultimoAnalisis;
    private String saludGeneral; // BUENA, REGULAR, CRITICA
    private ParametrosActualesDTO parametrosActuales;
}