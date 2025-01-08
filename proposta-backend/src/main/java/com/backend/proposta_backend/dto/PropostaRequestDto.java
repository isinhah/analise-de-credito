package com.backend.proposta_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropostaRequestDto {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String renda;
    private Double valorSolicitado;
    private int prazoPagamento;
}
