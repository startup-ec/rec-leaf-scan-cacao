package com.rec_leaf_scan_cacao.dto;

import java.math.BigDecimal;

public record MedidaPreventivaDTO(
        Long id,
        String titulo,
        String descripcion,
        String tipoMedida,
        String frecuenciaRecomendada,
        String temporadaAplicacion,
        BigDecimal costoEstimado,
        Integer efectividadPorcentaje,
        Boolean activo,
        String deficienciaNutrienteNombre
) {}
