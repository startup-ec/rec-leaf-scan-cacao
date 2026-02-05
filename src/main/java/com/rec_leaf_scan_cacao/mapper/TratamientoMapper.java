package com.rec_leaf_scan_cacao.mapper;


import com.rec_leaf_scan_cacao.dto.TratamientoDTO;
import com.rec_leaf_scan_cacao.entity.Tratamiento;

import java.util.List;
import java.util.stream.Collectors;

public class TratamientoMapper {

    public static TratamientoDTO toDTO(Tratamiento tratamiento) {
        return new TratamientoDTO(
                tratamiento.getId(),
                tratamiento.getNombreTratamiento(),
                tratamiento.getTipoTratamiento(),
                tratamiento.getDescripcion(),
                tratamiento.getDosisRecomendada(),
                tratamiento.getFrecuenciaAplicacion(),
                tratamiento.getTiempoEfectividadDias(),
                tratamiento.getCostoEstimadoPorHectarea(),
                tratamiento.getActivo()
        );
    }

    public static Tratamiento toEntity(TratamientoDTO dto) {
        if (dto == null) return null;

        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(dto.id());
        tratamiento.setNombreTratamiento(dto.nombreTratamiento());
        tratamiento.setTipoTratamiento(dto.tipoTratamiento());
        tratamiento.setDescripcion(dto.descripcion());
        tratamiento.setDosisRecomendada(dto.dosisRecomendada());
        tratamiento.setFrecuenciaAplicacion(dto.frecuenciaAplicacion());
        tratamiento.setTiempoEfectividadDias(dto.tiempoEfectividadDias());
        tratamiento.setCostoEstimadoPorHectarea(dto.costoEstimadoPorHectarea());
        tratamiento.setActivo(dto.activo());



        return tratamiento;
    }

    public static List<Tratamiento> toEntityList(List<TratamientoDTO> dtos) {
        if (dtos == null) return List.of();
        return dtos.stream()
                .map(TratamientoMapper::toEntity)
                .collect(Collectors.toList());
    }
}
