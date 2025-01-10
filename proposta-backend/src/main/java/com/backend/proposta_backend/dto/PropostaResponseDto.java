package com.backend.proposta_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropostaResponseDto {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String renda;
    private String valorSolicitadoFormatado;
    private int prazoPagamento;
    private String aprovada;
    private String observacao;
}