package com.api.analise_credito.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    private Long id;

    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String renda;
}