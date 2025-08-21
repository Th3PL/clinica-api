package com.fiap.Clinica_api.service;

import com.fiap.Clinica_api.domain.model.Paciente;
import com.fiap.Clinica_api.dto.paciente.PacienteEditDto;
import com.fiap.Clinica_api.dto.paciente.PacienteCreateDTO;
import com.fiap.Clinica_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Paciente> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Paciente> update(Long id,  PacienteEditDto dto) {
        return repository.findById(id)
                .map(paciente -> {
                    if (dto.getNome()!=null) {
                        paciente.setNome(dto.getNome());
                    }
                    if(dto.getEmail()!=null) {
                        paciente.setEmail(dto.getEmail());
                    }
                    return repository.save(paciente);
                });
    }

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
