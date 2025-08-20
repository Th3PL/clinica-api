package com.fiap.Clinica_api.dto;

import com.fiap.Clinica_api.domain.model.Paciente;

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
