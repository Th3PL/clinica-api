package com.fiap.Clinica_api.controller;

import com.fiap.Clinica_api.domain.model.Paciente;
import com.fiap.Clinica_api.dto.PacienteCreateDTO;
import com.fiap.Clinica_api.dto.PacienteResponseDTO;
import com.fiap.Clinica_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> save(@RequestBody PacienteCreateDTO dto) {
        return ResponseEntity.status(201).body(new PacienteResponseDTO().toDto(service.save(dto)));
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteResponseDTO> findById(@PathVariable Long id) {
        return service.findById(id).map(paciente -> {
            return new PacienteResponseDTO().toDto(paciente);
        }).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
