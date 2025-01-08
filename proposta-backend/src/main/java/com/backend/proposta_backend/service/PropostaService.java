package com.backend.proposta_backend.service;

import com.backend.proposta_backend.dto.PropostaRequestDto;
import com.backend.proposta_backend.dto.PropostaResponseDto;
import com.backend.proposta_backend.repository.PropostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PropostaService {

    private PropostaRepository propostaRepository;

    public PropostaResponseDto criar(PropostaRequestDto requestDto) {
//        propostaRepository.save(requestDto);
        return null;
    }
}
