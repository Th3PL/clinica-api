package com.fiap.Clinica_api.controller;

import com.fiap.Clinica_api.domain.model.Consulta;
import com.fiap.Clinica_api.domain.model.StatusConsulta;
import com.fiap.Clinica_api.dto.consulta.ConsultaCreateDTO;
import com.fiap.Clinica_api.dto.consulta.ConsultaResponseDTO;
import com.fiap.Clinica_api.dto.medico.MedicoResponseDTO;
import com.fiap.Clinica_api.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ClinicaController {

    @Autowired
    ClinicaService service;

    @PostMapping("/novaConsulta")
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

    @GetMapping("/medico/{id}")
    public ResponseEntity<List<ConsultaResponseDTO>> listarPorMedico(@PathVariable Long id) {
        List<ConsultaResponseDTO> consultas = service.listarConsultasPorMedico(id)
                .stream()
                .map(c -> new ConsultaResponseDTO().toDto(c))
                .toList();

        return ResponseEntity.ok(consultas);
    }

}
