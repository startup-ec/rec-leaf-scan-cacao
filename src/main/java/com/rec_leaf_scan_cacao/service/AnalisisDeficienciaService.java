package com.rec_leaf_scan_cacao.service;

import com.rec_leaf_scan_cacao.entity.AnalisisDeficiencia;
import com.rec_leaf_scan_cacao.repository.AnalisisDeficienciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnalisisDeficienciaService {

    private final AnalisisDeficienciaRepository repository;

    @Transactional
    public AnalisisDeficiencia insertar(AnalisisDeficiencia analisis) {
        return repository.save(analisis);
    }

    @Transactional(readOnly = true)
    public List<AnalisisDeficiencia> consultarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<AnalisisDeficiencia> consultarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public AnalisisDeficiencia actualizar(Long id, AnalisisDeficiencia analisisActualizado) {
        return repository.findById(id)
                .map(analisis -> {
                    analisis.setArchivo(analisisActualizado.getArchivo());
                    analisis.setImagenBase64(analisisActualizado.getImagenBase64());
                    analisis.setFecha(analisisActualizado.getFecha());

                    analisis.setEs_valido(analisisActualizado.getEs_valido());
                    analisis.setMensaje(analisisActualizado.getMensaje());
                    analisis.setTipo_alerta(analisisActualizado.getTipo_alerta());
                    analisis.setEstadisticas(analisisActualizado.getEstadisticas());
                    analisis.setDetecciones(analisisActualizado.getDetecciones());
                    analisis.setRecomendaciones(analisisActualizado.getRecomendaciones());
                    analisis.setMetadata(analisisActualizado.getMetadata());
                    analisis.setNombreCultivo(analisisActualizado.getNombreCultivo());

                    return repository.save(analisis);
                })
                .orElseThrow(() -> new RuntimeException("Análisis no encontrado con id: " + id));
    }

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}