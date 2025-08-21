package com.fiap.Clinica_api.dto.consulta;

import com.fiap.Clinica_api.domain.model.Consulta;
import com.fiap.Clinica_api.domain.model.StatusConsulta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaResponseDTO {

    private Long id;
    private String nomeMedico;
    private String nomePaciente;
    private StatusConsulta status;

    public ConsultaResponseDTO toDto(Consulta consulta) {
        this.id = consulta.getId();
        this.nomeMedico = consulta.getMedico().getNome();
        this.nomePaciente = consulta.getPaciente().getNome();
        this.status = consulta.getStatus();
        return this;
    }
}
