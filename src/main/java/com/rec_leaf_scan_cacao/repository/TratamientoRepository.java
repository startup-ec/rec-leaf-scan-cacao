package com.rec_leaf_scan_cacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rec_leaf_scan_cacao.entity.Tratamiento;

import java.util.List;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    List<Tratamiento> findByActivoTrue();

    List<Tratamiento> findByTipoTratamiento(String tipoTratamiento);




    @Query("SELECT t FROM Tratamiento t WHERE t.tiempoEfectividadDias <= :diasMaximos AND t.activo = true ORDER BY t.tiempoEfectividadDias")
    List<Tratamiento> findTratamientosRapidos(@Param("diasMaximos") Integer diasMaximos);


}
