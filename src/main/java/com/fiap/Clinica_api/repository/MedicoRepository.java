package com.fiap.Clinica_api.repository;

import com.fiap.Clinica_api.domain.model.Consulta;
import com.fiap.Clinica_api.domain.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
