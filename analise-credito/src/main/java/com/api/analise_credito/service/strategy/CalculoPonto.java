package com.api.analise_credito.service.strategy;

import com.api.analise_credito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}