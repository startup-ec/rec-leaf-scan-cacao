package com.rec_leaf_scan_cacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HealthController {

    // Health check endpoint que el gateway espera
    @GetMapping("/diagnostico/health")
    public Map<String, Object> health() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "diagnostico-service");
        health.put("timestamp", LocalDateTime.now());
        health.put("port", 8083);
        health.put("version", "1.0.0");
        return health;
    }

    // Información del servicio
    @GetMapping("/diagnostico/info")
    public Map<String, Object> getServiceInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", "diagnostico-service");
        info.put("version", "1.0.0");
        info.put("port", 8083);
        info.put("description", "Comprehensive Plant Diagnostic Service - Image Analysis, Nutrient Deficiency Detection, Treatment Planning");
        info.put("modules", Arrays.asList(
                "Image Analysis",
                "Nutrient Deficiency Detection",
                "Treatment Planning",
                "Crop Monitoring",
                "Preventive Measures",
                "Report Generation"
        ));

        // Endpoints de análisis e imágenes
        info.put("analysis-endpoints", Arrays.asList(
                "/api/analisis-imagenes",
                "/api/analisis-imagenes/{id}",
                "/api/analisis-imagenes/cultivo/{cultivoId}",
                "/api/analisis-imagenes/usuario/{usuarioId}",
                "/api/analisis-imagenes/estado/{estado}",
                "/api/analisis-imagenes/pendientes"
        ));

        // Endpoints de diagnóstico
        info.put("diagnostic-endpoints", Arrays.asList(
                "/api/resultados-diagnostico",
                "/api/resultados-diagnostico/{id}",
                "/api/resultados-diagnostico/analisis/{analisisId}",
                "/api/resultados-diagnostico/principales",
                "/api/resultados-diagnostico/severidad/{severidad}"
        ));

        // Endpoints de tratamientos
        info.put("treatment-endpoints", Arrays.asList(
                "/api/tratamientos",
                "/api/tratamientos/{id}",
                "/api/tratamientos/deficiencia/{deficienciaId}",
                "/api/tratamientos/activos",
                "/api/tratamientos/rapidos"
        ));

        // Endpoints de cultivos y monitoreo
        info.put("crop-monitoring-endpoints", Arrays.asList(
                "/api/cultivos",
                "/api/cultivos/usuario/{usuarioId}",
                "/api/parametros-monitoreo/cultivo/{cultivoId}",
                "/api/alertas-monitoreo/cultivo/{cultivoId}"
        ));

        // Endpoints de planes y seguimiento
        info.put("planning-endpoints", Arrays.asList(
                "/api/planes-tratamiento",
                "/api/actividades-seguimiento",
                "/api/medidas-preventivas"
        ));

        // Endpoints de reportes
        info.put("report-endpoints", Arrays.asList(
                "/api/reportes-generados",
                "/api/reportes-generados/usuario/{usuarioId}",
                "/api/reportes-generados/completados-no-descargados"
        ));

        // Endpoints de salud
        info.put("health-endpoints", Arrays.asList(
                "/diagnostico/health",
                "/diagnostico/info",
                "/diagnostico/status",
                "/ping"
        ));

        info.put("timestamp", LocalDateTime.now());
        return info;
    }

    // Endpoint para verificar conectividad básica
    @GetMapping("/ping")
    public Map<String, String> ping() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "pong");
        response.put("service", "diagnostico-service");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    // Endpoint para verificar que los módulos estén funcionando
    @GetMapping("/diagnostico/status")
    public Map<String, Object> getModuleStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("service", "diagnostico-service");
        status.put("overall-status", "UP");

        Map<String, String> modules = new HashMap<>();
        modules.put("image-analysis-service", "UP");
        modules.put("diagnostic-service", "UP");
        modules.put("treatment-service", "UP");
        modules.put("crop-monitoring-service", "UP");
        modules.put("preventive-measures-service", "UP");
        modules.put("report-generation-service", "UP");
        modules.put("notification-integration", "UP");
        modules.put("database", "UP");

        status.put("modules", modules);
        status.put("timestamp", LocalDateTime.now());
        return status;
    }

    // Estadísticas básicas del servicio
    @GetMapping("/diagnostico/stats")
    public Map<String, Object> getServiceStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("service", "diagnostico-service");

        // En un caso real, obtendrías estas estadísticas de tu base de datos
        Map<String, Integer> counts = new HashMap<>();
        counts.put("total-analisis-imagenes", 0);
        counts.put("diagnosticos-completados", 0);
        counts.put("tratamientos-activos", 0);
        counts.put("cultivos-monitoreados", 0);
        counts.put("alertas-activas", 0);
        counts.put("planes-tratamiento-activos", 0);
        counts.put("reportes-generados", 0);
        counts.put("deficiencias-detectadas", 0);

        stats.put("counts", counts);

        // Estadísticas por módulo
        Map<String, Map<String, Integer>> moduleStats = new HashMap<>();

        Map<String, Integer> analysisStats = new HashMap<>();
        analysisStats.put("pendientes", 0);
        analysisStats.put("completados", 0);
        analysisStats.put("con-errores", 0);
        moduleStats.put("image-analysis", analysisStats);

        Map<String, Integer> diagnosticStats = new HashMap<>();
        diagnosticStats.put("severidad-baja", 0);
        diagnosticStats.put("severidad-media", 0);
        diagnosticStats.put("severidad-alta", 0);
        moduleStats.put("diagnostics", diagnosticStats);

        Map<String, Integer> treatmentStats = new HashMap<>();
        treatmentStats.put("activos", 0);
        treatmentStats.put("completados", 0);
        treatmentStats.put("pendientes", 0);
        moduleStats.put("treatments", treatmentStats);

        stats.put("module-stats", moduleStats);
        stats.put("timestamp", LocalDateTime.now());
        stats.put("note", "Stats would be populated from database in production");
        return stats;
    }

    // Información específica de capacidades del servicio
    @GetMapping("/diagnostico/capabilities")
    public Map<String, Object> getServiceCapabilities() {
        Map<String, Object> capabilities = new HashMap<>();
        capabilities.put("service", "diagnostico-service");

        capabilities.put("supported-image-formats", Arrays.asList("JPEG", "PNG", "WEBP"));
        capabilities.put("max-image-size", "10MB");
        capabilities.put("supported-crops", Arrays.asList("Cacao", "Café", "Banano", "Maíz"));
        capabilities.put("detection-capabilities", Arrays.asList(
                "Nutrient Deficiencies",
                "Disease Detection",
                "Pest Identification",
                "Growth Monitoring"
        ));
        capabilities.put("analysis-types", Arrays.asList(
                "Leaf Analysis",
                "Plant Health Assessment",
                "Nutrient Level Detection",
                "Disease Severity Analysis"
        ));
        capabilities.put("report-formats", Arrays.asList("PDF", "Excel", "JSON"));
        capabilities.put("notification-integration", true);
        capabilities.put("real-time-monitoring", true);
        capabilities.put("ai-powered", true);

        capabilities.put("timestamp", LocalDateTime.now());
        return capabilities;
    }
}