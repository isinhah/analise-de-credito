package com.api.analise_credito.service;

import com.api.analise_credito.domain.Proposta;
import com.api.analise_credito.exceptions.StrategyException;
import com.api.analise_credito.service.strategy.CalculoPonto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    private final List<CalculoPonto> calculoPontoList;
    private final NotificacaoRabbitService notificacaoRabbitService;
    private final String exchangePropostaConcluida;

    public AnaliseCreditoService(List<CalculoPonto> calculoPontoList,
                                 NotificacaoRabbitService notificacaoRabbitService,
                                 @Value("${rabbitmq.exchanges.proposta-concluida}") String exchangePropostaConcluida) {
        this.calculoPontoList = calculoPontoList;
        this.notificacaoRabbitService = notificacaoRabbitService;
        this.exchangePropostaConcluida = exchangePropostaConcluida;
    }

    public void analisar(Proposta proposta) {
        try {
            int pontos = calculoPontoList.stream()
                    .mapToInt(impl -> impl.calcular(proposta)).sum();
            proposta.setAprovada(pontos > 100);
        } catch (StrategyException ex) {
            proposta.setAprovada(false);
            proposta.setObservacao(ex.getMessage());
        }
        notificacaoRabbitService.notificar(exchangePropostaConcluida, proposta);
    }
}
