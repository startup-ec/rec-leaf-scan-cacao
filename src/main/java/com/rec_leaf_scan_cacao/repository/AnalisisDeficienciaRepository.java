package com.rec_leaf_scan_cacao.repository;

import com.rec_leaf_scan_cacao.entity.AnalisisDeficiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalisisDeficienciaRepository extends JpaRepository<AnalisisDeficiencia, Long> {
}