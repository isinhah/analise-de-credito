package com.backend.proposta_backend.service;

import com.backend.proposta_backend.dto.PropostaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificacaoService {

    private final RabbitTemplate rabbitTemplate;

    public void notificar(PropostaResponseDto proposta, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
