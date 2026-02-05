package com.rec_leaf_scan_cacao.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametrosHistoricoDTO {
    private List<MedicionParametroDTO> temperatura;
    private List<MedicionParametroDTO> humedadSuelo;
    private List<MedicionParametroDTO> phSuelo;
    private List<MedicionParametroDTO> precipitacion;
}
