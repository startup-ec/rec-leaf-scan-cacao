package com.rec_leaf_scan_cacao.entity;

import com.rec_leaf_scan_cacao.dto.PlanTratamientoJson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "planes_tratamiento_analisis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanTratamientoAnalisis{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "analisis_id", nullable = false)
    private Long analisisId;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    // Almacenar el JSON completo del plan de tratamiento
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "plan_tratamiento", columnDefinition = "json", nullable = false)
    private PlanTratamientoJson planTratamiento;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}