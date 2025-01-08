package com.backend.proposta_backend.mapper;

import com.backend.proposta_backend.dto.PropostaRequestDto;
import com.backend.proposta_backend.entity.Proposta;
import org.mapstruct.Mapper;

@Mapper
public interface PropostaMapper {

    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);
}
