package com.fiap.Clinica_api.service;

import com.fiap.Clinica_api.domain.model.Paciente;
import com.fiap.Clinica_api.dto.PacienteCreateDTO;
import com.fiap.Clinica_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;


    public Paciente save(PacienteCreateDTO dto) {
        Paciente p = new Paciente();

        p.setCpf(dto.cpf());
        p.setEmail(dto.email());
        p.setNome(dto.nome());
        return repository.save(p);
    }

    public Paciente findById(Paciente paciente) {
        return repository.findById(paciente.getId()).get();
    }

}
