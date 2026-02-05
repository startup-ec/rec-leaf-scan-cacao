package com.rec_leaf_scan_cacao.service;

import com.rec_leaf_scan_cacao.entity.Cultivo;
import com.rec_leaf_scan_cacao.repository.CultivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CultivoService {
    @Autowired
    private CultivoRepository cultivoRepository;

    public Cultivo save(Cultivo cultivo) {
        return cultivoRepository.save(cultivo);
    }

    public Cultivo findById(Long id) {
        return cultivoRepository.findById(id).orElse(null);
    }

    public List<Cultivo> findAll() {
        return cultivoRepository.findAll();
    }

    public List<Cultivo> findByUsuarioId(Long usuarioId) {
        return cultivoRepository.findByUsuarioId(usuarioId);
    }

    public List<Cultivo> findByEstadoCultivo(Cultivo.EstadoCultivo estadoCultivo) {
        return cultivoRepository.findByEstadoCultivo(estadoCultivo);
    }

    public List<Cultivo> findByUsuarioIdAndEstadoCultivo(Long usuarioId, Cultivo.EstadoCultivo estadoCultivo) {
        return cultivoRepository.findByUsuarioIdAndEstadoCultivo(usuarioId, estadoCultivo);
    }

    public List<Cultivo> findByVariedadCacao(String variedadCacao) {
        return cultivoRepository.findByVariedadCacao(variedadCacao);
    }

    public BigDecimal getTotalAreaActivaPorUsuario(Long usuarioId) {
        return cultivoRepository.getTotalAreaActivaPorUsuario(usuarioId);
    }

    public void deleteById(Long id) {
        cultivoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return cultivoRepository.existsById(id);
    }
}
