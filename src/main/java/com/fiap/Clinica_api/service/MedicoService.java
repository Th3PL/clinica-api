package com.fiap.Clinica_api.service;

import com.fiap.Clinica_api.domain.model.Medico;
import com.fiap.Clinica_api.domain.model.Paciente;
import com.fiap.Clinica_api.dto.medico.MedicoCreateDTO;
import com.fiap.Clinica_api.dto.medico.MedicoEditDTO;
import com.fiap.Clinica_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico save(MedicoCreateDTO dto){
        Medico m = new Medico();
        m.setNome(dto.getNome());
        m.setCrm(dto.getCrm());

        return repository.save(m);
    }

    public Optional<Medico> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Medico> update(Long id, MedicoEditDTO dto){
        return repository.findById(id).map(medico -> {
            if(dto.getNome() != null){
                medico.setNome(dto.getNome());
            }
            return repository.save(medico);
        });

    }

    public List<Medico> findAll(){
        return repository.findAll();
    }

    public boolean deleteById(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
