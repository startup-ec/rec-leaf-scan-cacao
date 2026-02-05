package com.rec_leaf_scan_cacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametroMonitoreoDTO {

    private Long id;
    private Long cultivoId;          // Para identificar el cultivo
    private String nombreCultivo;    // Opcional, mostrar nombre en pantalla
    private String ubicacionNombre;    // Opcional, mostrar nombre en pantalla
    private LocalDate fechaMedicion;
    private BigDecimal humedadSuelo;
    private BigDecimal humedadAmbiente;
    private BigDecimal temperatura;
    private BigDecimal phSuelo;
    private BigDecimal precipitacionMm;
    private BigDecimal horasSol;
    private BigDecimal velocidadVientoKmh;
    private String fuenteDatos;
    private String coordenadasGps;
}
