package com.rec_leaf_scan_cacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerarPlanAnalisisRequest {
    @NotNull(message = "El ID del análisis es requerido")
    @JsonProperty("analisisId")
    private Long analisisId;

    @NotNull(message = "El ID del análisis es requerido")
    @JsonProperty("usuarioId")
    private Long usuarioId;

    @NotNull(message = "El plan de tratamiento es requerido")
    @JsonProperty("planTratamiento")
    private PlanTratamientoJson planTratamiento;
}