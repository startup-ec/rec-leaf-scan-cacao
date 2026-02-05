package com.rec_leaf_scan_cacao.controller;

import com.rec_leaf_scan_cacao.dto.GenerarPlanRequest;
import com.rec_leaf_scan_cacao.dto.PlanGeneradoResponse;
import com.rec_leaf_scan_cacao.dto.PlanTratamientosDTO;
import com.rec_leaf_scan_cacao.service.PlanTratamientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/agricultura/planes-tratamiento")
public class PlanTratamientoController {

    private final PlanTratamientoService planService;

    public PlanTratamientoController(PlanTratamientoService planService) {
        this.planService = planService;
    }




    @GetMapping("/{id}")
    public ResponseEntity<PlanTratamientosDTO> obtenerPlan(@PathVariable Long id) {
        try {
            return planService.obtenerPlanPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


}