package com.backend.proposta_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
