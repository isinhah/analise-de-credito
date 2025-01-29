package com.backend.proposta_backend.listener;

import com.backend.proposta_backend.dto.PropostaResponseDto;
import com.backend.proposta_backend.entity.Proposta;
import com.backend.proposta_backend.mapper.PropostaMapper;
import com.backend.proposta_backend.repository.PropostaRepository;
import com.backend.proposta_backend.service.WebSocketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluidaListener {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private WebSocketService webSocketService;

    @RabbitListener(queues = "${spring.rabbitmq.queue.proposta-concluida}")
    public void propostaConcluida(Proposta proposta) {
        atualizarProposta(proposta);
        PropostaResponseDto responseDto = PropostaMapper.INSTANCE.convertEntityToDto(proposta);
        webSocketService.notificar(responseDto);
    }

    private void atualizarProposta(Proposta proposta) {
        propostaRepository.atualizarProposta(proposta.getId(), proposta.getAprovada(), proposta.getObservacao());
    }
}