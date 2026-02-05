package com.rec_leaf_scan_cacao.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import com.rec_leaf_scan_cacao.enums.GeneralEnums;
import lombok.Data;

@Data
public class PlanTratamientosDTO {
    private Long id;
    private BigDecimal costoEstimado;
    private Integer duracionDias;
    private LocalDate fechaInicioSugerida;
    private LocalDateTime fechaCreacion;
    private GeneralEnums.EstadoPlan estado;
    private String instruccionesDetalladas;
    private GeneralEnums.Prioridad prioridad;

    // Relaciones simplificadas (solo IDs o nombres)
    private Long resultadoDiagnosticoId;
    private Long tratamientoId;
    private String nombreTratamiento;
    private List<ActividadSeguimientoDTO> actividadesSeguimiento;

}

