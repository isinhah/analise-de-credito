package com.backend.proposta_backend.service;

import com.backend.proposta_backend.dto.PropostaRequestDto;
import com.backend.proposta_backend.dto.PropostaResponseDto;
import com.backend.proposta_backend.entity.Proposta;
import com.backend.proposta_backend.mapper.PropostaMapper;
import com.backend.proposta_backend.repository.PropostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;

    public PropostaResponseDto criar(PropostaRequestDto requestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);
        propostaRepository.save(proposta);

        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }
}