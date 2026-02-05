package com.rec_leaf_scan_cacao.controller;

import com.rec_leaf_scan_cacao.entity.AnalisisDeficiencia;
import com.rec_leaf_scan_cacao.service.AnalisisDeficienciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agricultura/analisis-deficiencia")
@RequiredArgsConstructor
public class AnalisisDeficienciaController {

    private final AnalisisDeficienciaService service;

    @PostMapping
    public ResponseEntity<AnalisisDeficiencia> insertar(@RequestBody AnalisisDeficiencia analisis) {
        try {
            AnalisisDeficiencia nuevoAnalisis = service.insertar(analisis);
            return new ResponseEntity<>(nuevoAnalisis, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<AnalisisDeficiencia>> consultarTodos() {
        try {
            List<AnalisisDeficiencia> analisis = service.consultarTodos();
            if (analisis.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(analisis, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalisisDeficiencia> consultarPorId(@PathVariable Long id) {
        return service.consultarPorId(id)
                .map(analisis -> new ResponseEntity<>(analisis, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnalisisDeficiencia> actualizar(
            @PathVariable Long id,
            @RequestBody AnalisisDeficiencia analisis) {
        try {
            AnalisisDeficiencia analisisActualizado = service.actualizar(id, analisis);
            return new ResponseEntity<>(analisisActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}