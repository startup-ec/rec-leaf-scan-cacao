package com.rec_leaf_scan_cacao.mapper;


import com.rec_leaf_scan_cacao.dto.CultivoDTO;
import com.rec_leaf_scan_cacao.entity.Cultivo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CultivoMapper {

    public CultivoDTO toDTO(Cultivo cultivo) {
        if (cultivo == null) {
            return null;
        }

        return CultivoDTO.builder()
                .id(cultivo.getId())
                .usuarioId(cultivo.getUsuarioId())
                .nombreCultivo(cultivo.getNombreCultivo())
                .variedadCacao(cultivo.getVariedadCacao())
                .fechaSiembra(cultivo.getFechaSiembra())
                .areaHectareas(cultivo.getAreaHectareas())
                .ubicacionNombre(cultivo.getUbicacionNombre())
                .latitud(cultivo.getLatitud())
                .longitud(cultivo.getLongitud())
                .altitud(cultivo.getAltitud())
                .tipoSuelo(cultivo.getTipoSuelo())
                .sistemaRiego(cultivo.getSistemaRiego())
                .estadoCultivo(cultivo.getEstadoCultivo() != null ?
                        cultivo.getEstadoCultivo().name() : null)
                .notas(cultivo.getNotas())
                .fechaCreacion(cultivo.getFechaCreacion())
                .fechaActualizacion(cultivo.getFechaActualizacion())
                // Contadores opcionales (solo si necesitas esta info)

                .build();
    }

    public List<CultivoDTO> toDTOList(List<Cultivo> cultivos) {
        if (cultivos == null) {
            return null;
        }

        return cultivos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Cultivo toEntity(CultivoDTO dto) {
        if (dto == null) {
            return null;
        }

        return Cultivo.builder()
                .id(dto.getId())
                .usuarioId(dto.getUsuarioId())
                .nombreCultivo(dto.getNombreCultivo())
                .variedadCacao(dto.getVariedadCacao())
                .fechaSiembra(dto.getFechaSiembra())
                .areaHectareas(dto.getAreaHectareas())
                .ubicacionNombre(dto.getUbicacionNombre())
                .latitud(dto.getLatitud())
                .longitud(dto.getLongitud())
                .altitud(dto.getAltitud())
                .tipoSuelo(dto.getTipoSuelo())
                .sistemaRiego(dto.getSistemaRiego())
                .estadoCultivo(dto.getEstadoCultivo() != null ?
                        Cultivo.EstadoCultivo.valueOf(dto.getEstadoCultivo()) : null)
                .notas(dto.getNotas())
                .fechaCreacion(dto.getFechaCreacion())
                .fechaActualizacion(dto.getFechaActualizacion())
                .build();
    }
}