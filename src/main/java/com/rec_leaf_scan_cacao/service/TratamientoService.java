package com.rec_leaf_scan_cacao.service;

import com.rec_leaf_scan_cacao.dto.TratamientoDTO;
import com.rec_leaf_scan_cacao.entity.Tratamiento;
import com.rec_leaf_scan_cacao.mapper.TratamientoMapper;
import com.rec_leaf_scan_cacao.repository.TratamientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TratamientoService {
    @Autowired
    private TratamientoRepository tratamientoRepository;

    public Tratamiento save(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public Optional<Tratamiento> findById(Long id) {
        return tratamientoRepository.findById(id);
    }

    public List<TratamientoDTO> findAll() {
        //return tratamientoRepository.findAll();
        return tratamientoRepository.findAll()
                .stream()
                .map(TratamientoMapper::toDTO)
                .toList();
    }

    public List<Tratamiento> findByDeficienciaNutrienteId(Long deficienciaId) {
        return null;
    }

    public List<Tratamiento> findByActivoTrue() {
        return tratamientoRepository.findByActivoTrue();
    }

    public List<Tratamiento> findByTipoTratamiento(String tipoTratamiento) {
        return tratamientoRepository.findByTipoTratamiento(tipoTratamiento);
    }

    public List<Tratamiento> findTratamientosActivosPorDeficiencia(Long deficienciaId) {
        return null;
    }

    public List<Tratamiento> findTratamientosRapidos(Integer diasMaximos) {
        return tratamientoRepository.findTratamientosRapidos(diasMaximos);
    }

    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }
}
