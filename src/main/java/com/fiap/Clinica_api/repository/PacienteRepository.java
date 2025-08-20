package com.fiap.Clinica_api.repository;

import com.fiap.Clinica_api.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
