package com.rec_leaf_scan_cacao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tratamientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "nombre_tratamiento", nullable = false)
    private String nombreTratamiento;

    @Column(name = "tipo_tratamiento")
    private String tipoTratamiento;

    private String descripcion;

    @Column(name = "dosis_recomendada")
    private String dosisRecomendada;

    @Column(name = "frecuencia_aplicacion")
    private String frecuenciaAplicacion;

    @Column(name = "tiempo_efectividad_dias")
    private Integer tiempoEfectividadDias;

    @Column(name = "costo_estimado_por_hectarea")
    private java.math.BigDecimal costoEstimadoPorHectarea;

    private Boolean activo = true;


}