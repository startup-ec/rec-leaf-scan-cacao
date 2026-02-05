package com.rec_leaf_scan_cacao.dto.dashboard;

import com.rec_leaf_scan_cacao.entity.Cultivo;
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
public class CultivoDetalleDTO {
    private Long id;
    private String nombreCultivo;
    private String variedadCacao;
    private BigDecimal areaHectareas;
    private Cultivo.EstadoCultivo estadoCultivo;
    private String ubicacionNombre;
    private List<AnalisisRecienteDTO> analisisRecientes;
    private List<DeficienciaActivaDTO> deficienciasActivas;
    private List<TratamientoActivoDTO> tratamientosActivos;
    private ParametrosHistoricoDTO parametrosHistorico;
}