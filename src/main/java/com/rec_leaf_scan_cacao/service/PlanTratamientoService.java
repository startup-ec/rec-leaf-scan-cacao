package com.rec_leaf_scan_cacao.service;

import com.rec_leaf_scan_cacao.dto.*;
import com.rec_leaf_scan_cacao.entity.*;
import com.rec_leaf_scan_cacao.enums.GeneralEnums;
import com.rec_leaf_scan_cacao.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.rec_leaf_scan_cacao.enums.GeneralEnums.Severidad.*;


@Service
@Transactional
public class PlanTratamientoService {

    public final TratamientoRepository tratamientoRepository;



    public PlanTratamientoService(
                                  TratamientoRepository tratamientoRepository

                                 ) {
        this.tratamientoRepository = tratamientoRepository;

    }

    public Optional<PlanTratamientosDTO> obtenerPlanPorId(Long id) {
        return null;
    }


    public Tratamiento seleccionarMejorTratamiento(List<Tratamiento> tratamientos, GeneralEnums.Severidad severidad) {
        // Priorizar tratamientos más efectivos para casos severos
        if (severidad == CRITICO || severidad == SEVERO) {
            return tratamientos.stream()
                    .max((t1, t2) -> Integer.compare(t1.getTiempoEfectividadDias(), t2.getTiempoEfectividadDias()))
                    .orElse(tratamientos.get(0));
        }

        // Para casos leves/moderados, balance entre costo y efectividad
        return tratamientos.stream()
                .min((t1, t2) -> t1.getCostoEstimadoPorHectarea().compareTo(t2.getCostoEstimadoPorHectarea()))
                .orElse(tratamientos.get(0));
    }






    public String generarDescripcionSeguimiento(GeneralEnums.Severidad severidad, Integer dia) {
        StringBuilder desc = new StringBuilder();
        desc.append("Inspección programada para el día ").append(dia).append(" del tratamiento.\n");
        desc.append("Verificar:\n");
        desc.append("- Estado general del cultivo\n");
        desc.append("- Evolución de las áreas afectadas\n");
        desc.append("- Efectos secundarios o reacciones adversas\n");

        if (severidad == GeneralEnums.Severidad.CRITICO || severidad == GeneralEnums.Severidad.SEVERO) {
            desc.append("- Tomar fotografías para comparación\n");
            desc.append("- Medir áreas afectadas\n");
            desc.append("- Registrar cualquier cambio significativo\n");
        }

        return desc.toString();
    }



}