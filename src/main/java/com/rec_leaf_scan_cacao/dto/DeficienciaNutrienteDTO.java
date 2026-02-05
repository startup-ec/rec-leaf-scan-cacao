package com.rec_leaf_scan_cacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeficienciaNutrienteDTO {

    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String sintomasVisuales;
    private String nutrienteDeficiente;
    private Boolean activo;

    // Opcional: puedes agregar contadores en lugar de listas completas
    private Integer cantidadTratamientos;
    private Integer cantidadResultadosDiagnostico;
    private Integer cantidadMedidasPreventivas;
}