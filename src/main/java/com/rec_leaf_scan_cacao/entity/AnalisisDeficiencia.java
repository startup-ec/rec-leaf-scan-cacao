package com.rec_leaf_scan_cacao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "analisis_deficiencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalisisDeficiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String archivo;

    private String nombreCultivo;

    private String sector;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String imagenBase64;

    @Column(nullable = false)
    private LocalDate fecha;

    // Resultados del análisis YOLO
    @Column(nullable = false)
    private Boolean es_valido;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String tipo_alerta;

    // Estadísticas generales (como JSON)
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json", nullable = false)
    private Estadisticas estadisticas;

    // Detalle de cada detección (como JSON array)
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json", nullable = false)
    private List<Detecciones> detecciones;

    // Recomendaciones de IA (como JSON)
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json", nullable = false)
    private Map<String, Object> recomendaciones;

    // Metadata opcional (como JSON)
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Metadata metadata;

    // Clases internas para mapear la estructura JSON

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Estadisticas {
        private Integer total_detecciones;
        private Integer deficiencias_unicas;
        private Double confianza_promedio;
        private Double confianza_maxima;
        private Map<String, Integer> por_tipo;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detecciones {
        private Integer region;
        private String deficiencia;
        private Double confianza;
        private BBox bbox;
        private Integer area;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BBox {
        private Integer x1;
        private Integer y1;
        private Integer x2;
        private Integer y2;
        private Integer ancho;
        private Integer alto;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Ubicacion {
        private Integer x1;
        private Integer y1;
        private Integer x2;
        private Integer y2;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Metadata {
        private String modelo;
        private String version;
        private Double umbralConfianza;
        private DimensionesImagen dimensionesImagen;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DimensionesImagen {
        private Integer ancho;
        private Integer alto;
    }
}