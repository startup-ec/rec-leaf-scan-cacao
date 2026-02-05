package com.rec_leaf_scan_cacao.dto;

import lombok.Data;

@Data
public class GenerarPlanRequest {
    private Long resultadoDiagnosticoId;
    private Long cultivoId;
    private Long id;
}