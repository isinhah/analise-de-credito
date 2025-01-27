package com.api.analise_credito.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proposta {

    private Long id;

    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;

    private Usuario usuario;
}