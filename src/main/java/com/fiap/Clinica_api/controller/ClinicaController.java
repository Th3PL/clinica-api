package com.fiap.Clinica_api.controller;

import com.fiap.Clinica_api.domain.model.Consulta;
import com.fiap.Clinica_api.dto.consulta.ConsultaCreateDTO;
import com.fiap.Clinica_api.dto.consulta.ConsultaResponseDTO;
import com.fiap.Clinica_api.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ClinicaController {

    @Autowired
    ClinicaService service;

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> novaConsulta(@RequestBody ConsultaCreateDTO dto){
        return ResponseEntity.status(201).body(new ConsultaResponseDTO().toDto(service.criarConsulta(dto)));
    }

    @PutMapping("confirmar/{id}")
    public ResponseEntity<Void> confirmarConsulta(@RequestParam Long id){
        service.confirmarConsulta(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("cancelar/{id}")
    public ResponseEntity<Void> cancelarConsulta(@RequestParam Long id){
        service.cancelarConsulta(id);
        return ResponseEntity.ok().build();
    }


}
