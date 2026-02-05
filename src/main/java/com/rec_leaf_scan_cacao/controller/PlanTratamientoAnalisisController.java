package com.rec_leaf_scan_cacao.controller;

import com.rec_leaf_scan_cacao.dto.*;
import com.rec_leaf_scan_cacao.entity.PlanTratamientoAnalisis;
import com.rec_leaf_scan_cacao.service.PlanTratamientoAnalisisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agricultura/planes-tratamiento-analisis")
@Slf4j
public class PlanTratamientoAnalisisController {

    private final PlanTratamientoAnalisisService service;

    public PlanTratamientoAnalisisController(PlanTratamientoAnalisisService service) {
        this.service = service;
    }

    @PostMapping("/generar-analisis")
    public ResponseEntity<GenerarPlanAnalisisResponse> generarPlan(@RequestBody GenerarPlanAnalisisRequest request) {
        log.info("🚀 POST /api/planes-tratamiento - Generando plan para análisis: {}", request.getAnalisisId());

        GenerarPlanAnalisisResponse response = service.generarPlan(request);

        if (response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<List<PlanTratamientoAnalisis>> obtenerTodos() {
        log.info("📋 GET /api/planes-tratamiento - Obteniendo todos los planes");
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanTratamientoAnalisis> obtenerPorId(@PathVariable Long id) {
        log.info("🔍 GET /api/planes-tratamiento/{} - Obteniendo plan por ID", id);
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @GetMapping("/analisis/{analisisId}")
    public ResponseEntity<List<PlanTratamientoAnalisis>> obtenerPorAnalisisId(@PathVariable Long analisisId) {
        log.info("🔍 GET /api/planes-tratamiento/analisis/{} - Obteniendo planes por análisis", analisisId);
        return ResponseEntity.ok(service.obtenerPorAnalisisId(analisisId));
    }
}