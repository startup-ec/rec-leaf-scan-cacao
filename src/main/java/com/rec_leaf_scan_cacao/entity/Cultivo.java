package com.rec_leaf_scan_cacao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cultivos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "nombre_cultivo", nullable = false)
    private String nombreCultivo;

    @Column(name = "variedad_cacao")
    private String variedadCacao;

    @Column(name = "fecha_siembra")
    private java.time.LocalDate fechaSiembra;

    @Column(name = "area_hectareas")
    private java.math.BigDecimal areaHectareas;

    @Column(name = "ubicacion_nombre")
    private String ubicacionNombre;

    private java.math.BigDecimal latitud;

    private java.math.BigDecimal longitud;

    private Integer altitud;

    @Column(name = "tipo_suelo")
    private String tipoSuelo;

    @Column(name = "sistema_riego")
    private String sistemaRiego;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cultivo")
    private EstadoCultivo estadoCultivo = EstadoCultivo.ACTIVO;

    private String notas;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;



    public enum EstadoCultivo {
        ACTIVO, INACTIVO, COSECHADO
    }
}