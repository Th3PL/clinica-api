package com.fiap.Clinica_api.repository;

import com.fiap.Clinica_api.domain.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByMedicoId(Long medicoId);
}
