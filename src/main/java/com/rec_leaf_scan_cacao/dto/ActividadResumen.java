package com.rec_leaf_scan_cacao.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActividadResumen {
    private Long id;
    private String nombre;
    private LocalDateTime fechaProgramada;
    private String descripcion;
}