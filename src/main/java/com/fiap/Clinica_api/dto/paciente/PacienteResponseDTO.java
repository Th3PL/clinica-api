package com.fiap.Clinica_api.dto.paciente;

import com.fiap.Clinica_api.domain.model.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteResponseDTO {

    private Long id;
    private String nome;

    public PacienteResponseDTO() {
    }


    public PacienteResponseDTO toDto(Paciente p) {

        this.id = p.getId();
        this.nome = p.getNome();
        return this;

    }
}
