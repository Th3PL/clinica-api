package com.fiap.Clinica_api.controller;

import com.fiap.Clinica_api.dto.medico.MedicoCreateDTO;
import com.fiap.Clinica_api.dto.medico.MedicoEditDTO;
import com.fiap.Clinica_api.dto.medico.MedicoResponseDTO;
import com.fiap.Clinica_api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping("{id}")
    public ResponseEntity<MedicoResponseDTO> update(@PathVariable Long id,
                                                    @RequestBody  MedicoEditDTO dto){
        return service.update(id, dto)
                .map(medico -> new MedicoResponseDTO().toDto(medico)
                ).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> findAll(){
        return ResponseEntity.ok(
                service
                        .findAll()
                        .stream()
                        .map( medico -> {
                            return new MedicoResponseDTO().toDto(medico);
                        })
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MedicoResponseDTO> delete(@PathVariable Long id){
        boolean result = service.deleteById(id);
        if(result){
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
