package com.fiap.Clinica_api.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Pattern(regexp="\\d{11}")
        @Column(name = "cpf", nullable = false, unique = true, length = 11)
        private String cpf;

        @Email
        @NotBlank
        @Column(name = "email", nullable = false)
        private String email;

        @Column(nullable = false)
        private String nome;

        @OneToMany(mappedBy = "paciente")
        private List<Consulta> consultas = new ArrayList<>();
}
