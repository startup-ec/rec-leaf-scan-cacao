package com.rec_leaf_scan_cacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerarPlanAnalisisResponse {

    private boolean success;
    private String message;
    private DatosPlan data;
    private String error;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatosPlan {
        private Long id;

        @JsonProperty("analisisId")
        private Long analisisId;

        @JsonProperty("planTratamiento")
        private PlanTratamientoJson planTratamiento;

        @JsonProperty("fechaCreacion")
        private LocalDateTime fechaCreacion;
    }

    // Constructor para respuesta exitosa
    public static GenerarPlanAnalisisResponse success(Long id, Long analisisId,
                                              PlanTratamientoJson planTratamiento,
                                              LocalDateTime fechaCreacion) {
        GenerarPlanAnalisisResponse response = new GenerarPlanAnalisisResponse();
        response.setSuccess(true);
        response.setMessage("Plan de tratamiento generado exitosamente");
        response.setData(new DatosPlan(id, analisisId, planTratamiento, fechaCreacion));
        return response;
    }

    // Constructor para respuesta de error
    public static GenerarPlanAnalisisResponse error(String errorMessage) {
        GenerarPlanAnalisisResponse response = new GenerarPlanAnalisisResponse();
        response.setSuccess(false);
        response.setMessage("Error al generar plan de tratamiento");
        response.setError(errorMessage);
        return response;
    }
}