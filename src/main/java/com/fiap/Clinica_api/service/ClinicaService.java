package com.fiap.Clinica_api.service;

import com.fiap.Clinica_api.domain.model.Consulta;
import com.fiap.Clinica_api.domain.model.Medico;
import com.fiap.Clinica_api.domain.model.Paciente;
import com.fiap.Clinica_api.domain.model.StatusConsulta;
import com.fiap.Clinica_api.dto.consulta.ConsultaCreateDTO;
import com.fiap.Clinica_api.repository.ClinicaRepository;
import com.fiap.Clinica_api.repository.MedicoRepository;
import com.fiap.Clinica_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaService {

    @Autowired
    public ClinicaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


    public Consulta criarConsulta(ConsultaCreateDTO dto) {
        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return consultaRepository.save(new Consulta(medico, paciente));
    }

    public void confirmarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setStatus(StatusConsulta.CONFIRMADA);
        consultaRepository.save(consulta);
    }

    public void cancelarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setStatus(StatusConsulta.CANCELADA);
        consultaRepository.save(consulta);
    }

    public Optional<Consulta> consultaPorId(Long id) {
        return consultaRepository.findById(id);
    }

    public List<Consulta> listarConsultasPorMedico(Long medicoId) {
        return consultaRepository.findByMedicoId(medicoId);
    }
}
