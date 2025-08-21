package com.fiap.Clinica_api.dto.consulta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaCreateDTO {

    private Long medicoId;
    private Long pacienteId;

}
