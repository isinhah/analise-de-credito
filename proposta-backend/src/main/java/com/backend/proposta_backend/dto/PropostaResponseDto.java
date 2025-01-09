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
    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private String observacao;
}
