package com.backend.proposta_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String renda;
    @OneToOne(mappedBy = "usuario")
    private Proposta proposta;

}
