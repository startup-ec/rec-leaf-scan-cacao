package com.rec_leaf_scan_cacao.service;


import com.rec_leaf_scan_cacao.dto.GenerarPlanAnalisisRequest;
import com.rec_leaf_scan_cacao.dto.GenerarPlanAnalisisResponse;
import com.rec_leaf_scan_cacao.entity.PlanTratamientoAnalisis;
import com.rec_leaf_scan_cacao.repository.PlanTratamientoAnalisisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlanTratamientoAnalisisService {

    private final PlanTratamientoAnalisisRepository repository;

    @Transactional
    public GenerarPlanAnalisisResponse generarPlan(GenerarPlanAnalisisRequest request) {
        try {
            log.info("📥 Generando plan de tratamiento para análisis ID: {}", request.getAnalisisId());
            log.debug("📋 Plan recibido: {}", request.getPlanTratamiento());

            PlanTratamientoAnalisis planTratamiento = new PlanTratamientoAnalisis();
            planTratamiento.setAnalisisId(request.getAnalisisId());
            planTratamiento.setUsuarioId(request.getUsuarioId());
            planTratamiento.setPlanTratamiento(request.getPlanTratamiento());

            // Guardar en base de datos
            PlanTratamientoAnalisis saved = repository.save(planTratamiento);

            log.info("✅ Plan de tratamiento guardado con ID: {}", saved.getId());

            return GenerarPlanAnalisisResponse.success(
                    saved.getId(),
                    saved.getAnalisisId(),
                    saved.getPlanTratamiento(),
                    saved.getFechaCreacion()
            );

        } catch (Exception e) {
            log.error("❌ Error al generar plan de tratamiento: {}", e.getMessage(), e);
            return GenerarPlanAnalisisResponse.error(e.getMessage());
        }
    }

    public List<PlanTratamientoAnalisis> obtenerTodos() {
        return repository.findAll();
    }

    public PlanTratamientoAnalisis obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado con ID: " + id));
    }

    public List<PlanTratamientoAnalisis> obtenerPorAnalisisId(Long analisisId) {
        return repository.findByAnalisisId(analisisId);
    }
}