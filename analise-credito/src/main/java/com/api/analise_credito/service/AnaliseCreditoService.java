package com.api.analise_credito.service;

import com.api.analise_credito.domain.Proposta;
import com.api.analise_credito.service.strategy.CalculoPonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    @Autowired
    private List<CalculoPonto> calculoPontoList;

    public void analisar(Proposta proposta) {
        int pontuacao = calculoPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
    }
}
