package com.rec_leaf_scan_cacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rec_leaf_scan_cacao.entity.Cultivo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CultivoRepository extends JpaRepository<Cultivo, Long> {
    List<Cultivo> findByUsuarioId(Long usuarioId);

    List<Cultivo> findByEstadoCultivo(Cultivo.EstadoCultivo estadoCultivo);

    List<Cultivo> findByUsuarioIdAndEstadoCultivo(Long usuarioId, Cultivo.EstadoCultivo estadoCultivo);

    List<Cultivo> findByVariedadCacao(String variedadCacao);


    @Query("SELECT SUM(c.areaHectareas) FROM Cultivo c WHERE c.usuarioId = :usuarioId AND c.estadoCultivo = 'ACTIVO'")
    java.math.BigDecimal getTotalAreaActivaPorUsuario(@Param("usuarioId") Long usuarioId);


    Long countByEstadoCultivo(Cultivo.EstadoCultivo estadoCultivo);

    @Query("SELECT COALESCE(SUM(c.areaHectareas), 0) FROM Cultivo c")
    BigDecimal sumAreaHectareas();
}
