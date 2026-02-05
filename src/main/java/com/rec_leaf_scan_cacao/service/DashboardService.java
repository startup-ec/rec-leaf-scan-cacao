package com.rec_leaf_scan_cacao.service;


import com.rec_leaf_scan_cacao.dto.dashboard.*;
import com.rec_leaf_scan_cacao.entity.Cultivo;
import com.rec_leaf_scan_cacao.enums.GeneralEnums;
import com.rec_leaf_scan_cacao.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DashboardService {

    private final CultivoRepository cultivoRepository;


    public DashboardResumenDTO obtenerResumenDashboard(DashboardFiltroDTO filtro) {
        log.info("Obteniendo resumen de dashboard con filtros: {}", filtro);

        LocalDateTime fechaInicio = filtro.getFechaInicio() != null ?
                filtro.getFechaInicio() : LocalDateTime.now().minusMonths(1);
        LocalDateTime fechaFin = filtro.getFechaFin() != null ?
                filtro.getFechaFin() : LocalDateTime.now();

        return DashboardResumenDTO.builder()
                .estadisticasGenerales(obtenerEstadisticasGenerales(fechaInicio, fechaFin, filtro))
                .cultivosActivos(obtenerCultivosActivos(filtro))
                .alertasRecientes(obtenerAlertasRecientes(filtro))
                .proximasActividades(obtenerProximasActividades(filtro))
                .estadisticasDeficiencias(obtenerEstadisticasDeficiencias(fechaInicio, fechaFin, filtro))
                .estadisticasTratamientos(obtenerEstadisticasTratamientos(fechaInicio, fechaFin, filtro))
                .build();
    }

    private EstadisticasGeneralesDTO obtenerEstadisticasGenerales(
            LocalDateTime fechaInicio, LocalDateTime fechaFin, DashboardFiltroDTO filtro) {

        Long totalCultivos = cultivoRepository.count();
        Long cultivosActivos = cultivoRepository.countByEstadoCultivo(Cultivo.EstadoCultivo.ACTIVO);
        BigDecimal areaTotal = cultivoRepository.sumAreaHectareas();





        return EstadisticasGeneralesDTO.builder()
                .totalCultivos(totalCultivos)
                .cultivosActivos(cultivosActivos)
                .areaTotal(areaTotal != null ? areaTotal : BigDecimal.ZERO)


                .build();
    }

    private List<CultivoResumenDTO> obtenerCultivosActivos(DashboardFiltroDTO filtro) {
        var cultivos = cultivoRepository.findByEstadoCultivo(Cultivo.EstadoCultivo.ACTIVO);

        return cultivos.stream()
                .map(cultivo -> {



                    return CultivoResumenDTO.builder()
                            .id(cultivo.getId())
                            .nombreCultivo(cultivo.getNombreCultivo())
                            .variedadCacao(cultivo.getVariedadCacao())
                            .areaHectareas(cultivo.getAreaHectareas())
                            .estadoCultivo(cultivo.getEstadoCultivo())
                            .ubicacionNombre(cultivo.getUbicacionNombre())


                            .build();
                })
                .collect(Collectors.toList());
    }

    private String calcularSaludCultivo(Integer deficienciasActivas) {
        if (deficienciasActivas == 0) return "BUENA";
        if (deficienciasActivas <= 2) return "REGULAR";
        return "CRITICA";
    }

    private List<AlertaDTO> obtenerAlertasRecientes(DashboardFiltroDTO filtro) {
        List<AlertaDTO> alertas = new ArrayList<>();
        LocalDateTime hace7Dias = LocalDateTime.now().minusDays(7);



        // Alertas de actividades vencidas



        return alertas.stream()
                .sorted((a1, a2) -> a2.getFechaGeneracion().compareTo(a1.getFechaGeneracion()))
                .limit(10)
                .collect(Collectors.toList());
    }

    private List<ProximaActividadDTO> obtenerProximasActividades(DashboardFiltroDTO filtro) {


        return null;
    }

    private EstadisticasDeficienciasDTO obtenerEstadisticasDeficiencias(
            LocalDateTime fechaInicio, LocalDateTime fechaFin, DashboardFiltroDTO filtro) {




        return EstadisticasDeficienciasDTO.builder()
                .build();
    }


    private EstadisticasTratamientosDTO obtenerEstadisticasTratamientos(
            LocalDateTime fechaInicio, LocalDateTime fechaFin, DashboardFiltroDTO filtro) {




        return EstadisticasTratamientosDTO.builder()


                .build();
    }

    public CultivoDetalleDTO obtenerDetalleCultivo(Long cultivoId) {
        var cultivo = cultivoRepository.findById(cultivoId)
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));






        var parametrosHistorico = obtenerParametrosHistorico(cultivoId);

        return CultivoDetalleDTO.builder()
                .id(cultivo.getId())
                .nombreCultivo(cultivo.getNombreCultivo())
                .variedadCacao(cultivo.getVariedadCacao())
                .areaHectareas(cultivo.getAreaHectareas())
                .estadoCultivo(cultivo.getEstadoCultivo())
                .ubicacionNombre(cultivo.getUbicacionNombre())



                .parametrosHistorico(parametrosHistorico)
                .build();
    }

    private ParametrosHistoricoDTO obtenerParametrosHistorico(Long cultivoId) {
        LocalDateTime hace30Dias = LocalDateTime.now().minusDays(30);


        return ParametrosHistoricoDTO.builder()


                .build();
    }
}