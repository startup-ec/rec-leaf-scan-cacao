package com.rec_leaf_scan_cacao.repository;

import com.rec_leaf_scan_cacao.entity.PlanTratamientoAnalisis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanTratamientoAnalisisRepository extends JpaRepository<PlanTratamientoAnalisis, Long> {

    List<PlanTratamientoAnalisis> findByAnalisisId(Long analisisId);

}