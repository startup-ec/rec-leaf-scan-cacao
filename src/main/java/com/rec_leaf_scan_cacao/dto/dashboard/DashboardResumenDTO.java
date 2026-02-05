package com.rec_leaf_scan_cacao.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResumenDTO {
    private EstadisticasGeneralesDTO estadisticasGenerales;
    private List<CultivoResumenDTO> cultivosActivos;
    private List<AlertaDTO> alertasRecientes;
    private List<ProximaActividadDTO> proximasActividades;
    private EstadisticasDeficienciasDTO estadisticasDeficiencias;
    private EstadisticasTratamientosDTO estadisticasTratamientos;
}