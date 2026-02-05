package com.rec_leaf_scan_cacao.controller;

import com.rec_leaf_scan_cacao.dto.CultivoDTO;
import com.rec_leaf_scan_cacao.entity.Cultivo;
import com.rec_leaf_scan_cacao.mapper.CultivoMapper;
import com.rec_leaf_scan_cacao.service.CultivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/agricultura/cultivos")
@RequiredArgsConstructor
public class CultivoController {

    @Autowired
    private CultivoService cultivoService;

    private final CultivoMapper cultivoMapper;

    @PostMapping
    public ResponseEntity<Cultivo> crearCultivo(@Valid @RequestBody Cultivo cultivo) {
        try {
            Cultivo nuevoCultivo = cultivoService.save(cultivo);
            return new ResponseEntity<>(nuevoCultivo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CultivoDTO> obtenerCultivoPorId(@PathVariable Long id) {
        try {
            Cultivo cultivo = cultivoService.findById(id);
            if (cultivo == null) {
                return ResponseEntity.notFound().build();
            }
            CultivoDTO cultivoDTO = cultivoMapper.toDTO(cultivo);
            return ResponseEntity.ok(cultivoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CultivoDTO>> obtenerTodosLosCultivos() {
        try {
            List<Cultivo> cultivos = cultivoService.findAll();
            List<CultivoDTO> cultivosDTO = cultivoMapper.toDTOList(cultivos);
            return ResponseEntity.ok(cultivosDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Cultivo>> obtenerCultivosPorUsuario(@PathVariable Long usuarioId) {
        try {
            List<Cultivo> cultivos = cultivoService.findByUsuarioId(usuarioId);
            if (cultivos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cultivos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/estado/{estadoCultivo}")
    public ResponseEntity<List<Cultivo>> obtenerCultivosPorEstado(@PathVariable Cultivo.EstadoCultivo estadoCultivo) {
        try {
            List<Cultivo> cultivos = cultivoService.findByEstadoCultivo(estadoCultivo);
            if (cultivos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cultivos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{usuarioId}/estado/{estadoCultivo}")
    public ResponseEntity<List<Cultivo>> obtenerCultivosPorUsuarioYEstado(
            @PathVariable Long usuarioId, @PathVariable Cultivo.EstadoCultivo estadoCultivo) {
        try {
            List<Cultivo> cultivos = cultivoService.findByUsuarioIdAndEstadoCultivo(usuarioId, estadoCultivo);
            if (cultivos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cultivos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/variedad/{variedadCacao}")
    public ResponseEntity<List<Cultivo>> obtenerCultivosPorVariedad(@PathVariable String variedadCacao) {
        try {
            List<Cultivo> cultivos = cultivoService.findByVariedadCacao(variedadCacao);
            if (cultivos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cultivos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{usuarioId}/area-total-activa")
    public ResponseEntity<BigDecimal> obtenerAreaTotalActivaPorUsuario(@PathVariable Long usuarioId) {
        try {
            BigDecimal areaTotal = cultivoService.getTotalAreaActivaPorUsuario(usuarioId);
            if (areaTotal == null)
                areaTotal = BigDecimal.ZERO;
            return new ResponseEntity<>(areaTotal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> verificarExistenciaCultivo(@PathVariable Long id) {
        try {
            boolean existe = cultivoService.existsById(id);
            return new ResponseEntity<>(existe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cultivo> actualizarCultivo(
            @PathVariable Long id, @Valid @RequestBody Cultivo cultivo) {
        Cultivo cultivoExistente = cultivoService.findById(id);
        if (cultivoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        if (cultivoExistente != null) {
            cultivo.setId(id);
            try {
                Cultivo cultivoActualizado = cultivoService.save(cultivo);
                return new ResponseEntity<>(cultivoActualizado, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarCultivo(@PathVariable Long id) {
        try {
            Cultivo cultivoExistente = cultivoService.findById(id);
            if (cultivoExistente != null) {
                cultivoService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Cultivo> cambiarEstadoCultivo(
            @PathVariable Long id, @RequestBody Cultivo.EstadoCultivo nuevoEstado) {
        try {
            Cultivo cultivoExistente = cultivoService.findById(id);
            if (cultivoExistente != null) {
                cultivoExistente.setEstadoCultivo(nuevoEstado);
                Cultivo cultivoActualizado = cultivoService.save(cultivoExistente);
                return new ResponseEntity<>(cultivoActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}