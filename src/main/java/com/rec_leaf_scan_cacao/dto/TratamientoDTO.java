package com.rec_leaf_scan_cacao.dto;


import java.math.BigDecimal;


public record TratamientoDTO(
        Long id,
        String nombreTratamiento,
        String tipoTratamiento,
        String descripcion,
        String dosisRecomendada,
        String frecuenciaAplicacion,
        Integer tiempoEfectividadDias,
        BigDecimal costoEstimadoPorHectarea,
        Boolean activo
) {}
