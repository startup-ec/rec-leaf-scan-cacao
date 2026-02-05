package com.rec_leaf_scan_cacao.controller;

import com.rec_leaf_scan_cacao.dto.dashboard.*;
import com.rec_leaf_scan_cacao.entity.Cultivo;
import com.rec_leaf_scan_cacao.service.DashboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/agricultura/dashobard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/resumen")
    public ResponseEntity<DashboardResumenDTO> obtenerResumen(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
            @RequestParam(required = false) List<Long> cultivoIds,
            @RequestParam Cultivo.EstadoCultivo estadoCultivo,
            @RequestParam String severidadMinima) {
        log.info("GET /api/v1/dashboard/resumen - fechaInicio: {}, fechaFin: {}", fechaInicio, fechaFin);

        DashboardFiltroDTO filtro = DashboardFiltroDTO.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .cultivoIds(cultivoIds)
                .estadoCultivo(estadoCultivo)
                .severidadMinima(severidadMinima)
                .build();

        DashboardResumenDTO resumen = dashboardService.obtenerResumenDashboard(filtro);
        return ResponseEntity.ok(resumen);
    }

    @GetMapping("/estadisticas/generales")
    public ResponseEntity<EstadisticasGeneralesDTO> obtenerEstadisticasGenerales(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {

        log.info("GET /api/v1/dashboard/estadisticas/generales");

        DashboardFiltroDTO filtro = DashboardFiltroDTO.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .build();

        DashboardResumenDTO resumen = dashboardService.obtenerResumenDashboard(filtro);
        return ResponseEntity.ok(resumen.getEstadisticasGenerales());
    }

    @GetMapping("/cultivos/activos")
    public ResponseEntity<List<CultivoResumenDTO>> obtenerCultivosActivos(
            @RequestParam(required = false) List<Long> cultivoIds) {

        log.info("GET /api/v1/dashboard/cultivos/activos");

        DashboardFiltroDTO filtro = DashboardFiltroDTO.builder()
                .cultivoIds(cultivoIds)
                .estadoCultivo(Cultivo.EstadoCultivo.ACTIVO)
                .build();

        DashboardResumenDTO resumen = dashboardService.obtenerResumenDashboard(filtro);
        return ResponseEntity.ok(resumen.getCultivosActivos());
    }

    @GetMapping("/cultivos/{id}/detalle")
    public ResponseEntity<CultivoDetalleDTO> obtenerDetalleCultivo(
            @PathVariable Long id) {

        log.info("GET /api/v1/dashboard/cultivos/{}/detalle", id);

        CultivoDetalleDTO detalle = dashboardService.obtenerDetalleCultivo(id);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/alertas")
    public ResponseEntity<List<AlertaDTO>> obtenerAlertas(
            @RequestParam String tipo,
            @RequestParam String severidad,
            @RequestParam Boolean soloNoLeidas) {

        log.info("GET /api/v1/dashboard/alertas - tipo: {}, severidad: {}", tipo, severidad);

        DashboardFiltroDTO filtro = DashboardFiltroDTO.builder()
                .severidadMinima(severidad)
                .build();

        DashboardResumenDTO resumen = dashboardService.obtenerResumenDashboard(filtro);
        List<AlertaDTO> alertas = resumen.getAlertasRecientes();

        // Filtrar por tipo si se especifica
        if (tipo != null && !tipo.isEmpty()) {
            alertas = alertas.stream()
                    .filter(a -> tipo.equals(a.getTipo()))
                    .toList();
        }

        // Filtrar solo no leídas si se especifica
        if (Boolean.TRUE.equals(soloNoLeidas)) {
            alertas = alertas.stream()
                    .filter(a -> Boolean.FALSE.equals(a.getLeida()))
                    .toList();
        }

        return ResponseEntity.ok(alertas);
    }

    @GetMapping("/actividades/proximas")
    public ResponseEntity<List<ProximaActividadDTO>> obtenerProximasActividades(
            @RequestParam(required = false, defaultValue = "30") Integer dias,
            @RequestParam Boolean soloPrioridadAlta) {

        log.info("GET /api/v1/dashboard/actividades/proximas - dias: {}", dias);

        DashboardFiltroDTO filtro = DashboardFiltroDTO.builder()
                .fechaInicio(LocalDateTime.now())
                .fechaFin(LocalDateTime.now().plusDays(dias))
                .build();

        DashboardResumenDTO resumen = dashboardService.obtenerResumenDashboard(filtro);
        List<ProximaActividadDTO> actividades = resumen.getProximasActividades();

        // Filtrar por prioridad alta si se especifica
        if (Boolean.TRUE.equals(soloPrioridadAlta)) {
            actividades = actividades.stream()
                    .filter(a -> "ALTA".equals(a.getPrioridad()))
                    .toList();
        }

        return ResponseEntity.ok(actividades);
    }

    @GetMapping("/estadisticas/deficiencias")
    public ResponseEntity<EstadisticasDeficienciasDTO> obtenerEstadisticasDeficiencias(
            @RequestParam
            @DateTimeFormat LocalDateTime fechaInicio,

            @RequestParam
            @DateTimeFormat LocalDateTime fechaFin) {

        log.info("GET /api/v1/dashboard/estadisticas/deficiencias");

        DashboardFiltroDTO filtro = DashboardFiltroDTO.builder()
                .fechaInicio(fechaInicio != null ? fechaInicio : LocalDateTime.now().minusMonths(3))
                .fechaFin(fechaFin != null ? fechaFin : LocalDateTime.now())
                .build();

        DashboardResumenDTO resumen = dashboardService.obtenerResumenDashboard(filtro);
        return ResponseEntity.ok(resumen.getEstadisticasDeficiencias());
    }

    @GetMapping("/estadisticas/tratamientos")
    public ResponseEntity<EstadisticasTratamientosDTO> obtenerEstadisticasTratamientos(
            @RequestParam
            @DateTimeFormat LocalDateTime fechaInicio,

            @RequestParam
            @DateTimeFormat LocalDateTime fechaFin) {

        log.info("GET /api/v1/dashboard/estadisticas/tratamientos");

        DashboardFiltroDTO filtro = DashboardFiltroDTO.builder()
                .fechaInicio(fechaInicio != null ? fechaInicio : LocalDateTime.now().minusMonths(3))
                .fechaFin(fechaFin != null ? fechaFin : LocalDateTime.now())
                .build();

        DashboardResumenDTO resumen = dashboardService.obtenerResumenDashboard(filtro);
        return ResponseEntity.ok(resumen.getEstadisticasTratamientos());
    }
}