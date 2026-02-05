package com.rec_leaf_scan_cacao.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class AnalisisImagenDTO {
    private Long id;
    private Long cultivoId;
    private Long usuarioId;
    private Long deficiencia_Id;
    private String nombreImagen;
    private String rutaImagenOriginal;
    private String rutaImagenProcesada;
    private String condicionesClima;
    private String ubicacionEspecifica;
    private String notasUsuario;
    private Map<String, Object> metadatosImagen = new HashMap<>();
    private Integer tiempoProcesamintoSegundos;

    private BigDecimal confianzaPrediccion;
    private String severidad; // "LEVE", "MODERADA" o "SEVERA"
    private Map<String, Object> areasAfectadas = new HashMap<>();

    private Boolean diagnosticoPrincipal;
    private String observacionesIa;
}