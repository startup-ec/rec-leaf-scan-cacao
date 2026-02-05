package com.rec_leaf_scan_cacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListarAnalisisImagenDTO {
    private Long id;
    private Long cultivoId;
    private String nombreCultivo; // Del cultivo
    private Long deficienciaId;
    private Long usuarioId;
    private String nombreImagen;
    private String rutaImagenOriginal;
    private String rutaImagenProcesada;
    private LocalDateTime fechaAnalisis;
    private String estadoProcesamiento;
    private Integer tiempoProcesamintoSegundos;
    private Map<String, Object> metadatosImagen;

    private String condicionesClima;
    private String notasUsuario;

    //private List<ResultadoDiagnosticoDTO> resultados; // Solo si necesitas incluirlos


}