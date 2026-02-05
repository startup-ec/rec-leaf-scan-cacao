package com.rec_leaf_scan_cacao.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlertaDTO {
    private Long id;
    private String tipo;
    private String severidad;
    private String mensaje;
    private String cultivoNombre;
    private Long cultivoId;
    private LocalDateTime fechaGeneracion;
    private Boolean leida;
}