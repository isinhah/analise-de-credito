package com.backend.proposta_backend.service;

import com.backend.proposta_backend.dto.PropostaRequestDto;
import com.backend.proposta_backend.dto.PropostaResponseDto;
import com.backend.proposta_backend.entity.Proposta;
import com.backend.proposta_backend.mapper.PropostaMapper;
import com.backend.proposta_backend.repository.PropostaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;
    private final NotificacaoRabbitService notificacaoRabbitService;
    private final String exchange;

    public PropostaService(PropostaRepository propostaRepository,
                           NotificacaoRabbitService notificacaoRabbitService,
                           @Value("${spring.rabbitmq.exchanges.proposta-pendente}") String exchange) {
        this.propostaRepository = propostaRepository;
        this.notificacaoRabbitService = notificacaoRabbitService;
        this.exchange = exchange;
    }

    @Transactional
    public PropostaResponseDto criar(PropostaRequestDto requestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);

        propostaRepository.save(proposta);

        notificarRabbitMq(proposta);
        notificacaoRabbitService.notificar(proposta, exchange);

        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    private void notificarRabbitMq(Proposta proposta) {
        try {
            notificacaoRabbitService.notificar(proposta, exchange);
        } catch (RuntimeException ex) {
          proposta.setIntegrada(false);
          propostaRepository.save(proposta);
        }
    }

    public List<PropostaResponseDto> obterProposta() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}