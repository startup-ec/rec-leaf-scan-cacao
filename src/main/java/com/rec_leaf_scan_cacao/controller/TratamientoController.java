package com.rec_leaf_scan_cacao.controller;

import com.rec_leaf_scan_cacao.dto.TratamientoDTO;
import com.rec_leaf_scan_cacao.entity.Tratamiento;
import com.rec_leaf_scan_cacao.service.TratamientoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/agricultura/tratamientos")
@RequiredArgsConstructor
@Slf4j
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @PostMapping
    public ResponseEntity<Tratamiento> crearTratamiento(@Valid @RequestBody Tratamiento tratamiento) {
        try {
            Tratamiento tratamientoGuardado = tratamientoService.save(tratamiento);
            return ResponseEntity.status(HttpStatus.CREATED).body(tratamientoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> obtenerTratamientoPorId(@PathVariable Long id) {
        Optional<Tratamiento> tratamiento = tratamientoService.findById(id);
        return tratamiento.map(t -> ResponseEntity.ok(t))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TratamientoDTO>> obtenerTodosLosTratamientos() {
        List<TratamientoDTO> tratamientosDTO = tratamientoService.findAll();
        return ResponseEntity.ok(tratamientosDTO);
    }

    @GetMapping("/deficiencia/{deficienciaId}")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosPorDeficiencia(@PathVariable Long deficienciaId) {
        List<Tratamiento> tratamientos = tratamientoService.findByDeficienciaNutrienteId(deficienciaId);
        return ResponseEntity.ok(tratamientos);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosActivos() {
        List<Tratamiento> tratamientos = tratamientoService.findByActivoTrue();
        return ResponseEntity.ok(tratamientos);
    }

    @GetMapping("/tipo/{tipoTratamiento}")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosPorTipo(@PathVariable String tipoTratamiento) {
        List<Tratamiento> tratamientos = tratamientoService.findByTipoTratamiento(tipoTratamiento);
        return ResponseEntity.ok(tratamientos);
    }

    @GetMapping("/activos/deficiencia/{deficienciaId}")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosActivosPorDeficiencia(@PathVariable Long deficienciaId) {
        List<Tratamiento> tratamientos = tratamientoService.findTratamientosActivosPorDeficiencia(deficienciaId);
        return ResponseEntity.ok(tratamientos);
    }

    @GetMapping("/rapidos")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosRapidos(@RequestParam Integer diasMaximos) {
        List<Tratamiento> tratamientos = tratamientoService.findTratamientosRapidos(diasMaximos);
        return ResponseEntity.ok(tratamientos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> actualizarTratamiento(
            @PathVariable Long id,
            @Valid @RequestBody Tratamiento tratamiento) {

        Optional<Tratamiento> tratamientoExistente = tratamientoService.findById(id);

        if (tratamientoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        try {
            tratamiento.setId(id);
            Tratamiento tratamientoActualizado = tratamientoService.save(tratamiento);
            return ResponseEntity.ok(tratamientoActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTratamiento(@PathVariable Long id) {
        Optional<Tratamiento> tratamientoExistente = tratamientoService.findById(id);

        if (tratamientoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        try {
            tratamientoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}