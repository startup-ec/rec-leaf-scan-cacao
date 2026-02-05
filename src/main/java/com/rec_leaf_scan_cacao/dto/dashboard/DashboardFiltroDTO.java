package com.rec_leaf_scan_cacao.dto.dashboard;

import com.rec_leaf_scan_cacao.entity.Cultivo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardFiltroDTO {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private List<Long> cultivoIds;
    private Cultivo.EstadoCultivo estadoCultivo;
    private String severidadMinima;
}