package com.fiap.Clinica_api.controller;

import com.fiap.Clinica_api.domain.model.Paciente;
import com.fiap.Clinica_api.dto.PacienteCreateDTO;
import com.fiap.Clinica_api.dto.PacienteResponseDTO;
import com.fiap.Clinica_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> save(@RequestBody PacienteCreateDTO dto) {
        return ResponseEntity.status(201).body(new PacienteResponseDTO().toDto(service.save(dto)));
    }

}
