package com.fiap.Clinica_api.controller;

import com.fiap.Clinica_api.dto.medico.MedicoCreateDTO;
import com.fiap.Clinica_api.dto.medico.MedicoResponseDTO;
import com.fiap.Clinica_api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {


    @Autowired
    private MedicoService service;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> save(@RequestBody MedicoCreateDTO dto){
        return ResponseEntity.status(201).body(new MedicoResponseDTO().toDto(service.save(dto)));
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicoResponseDTO> findById(@PathVariable Long id){
        return service.findById(id).map(medico -> {
            return new MedicoResponseDTO().toDto(medico);
        }).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
