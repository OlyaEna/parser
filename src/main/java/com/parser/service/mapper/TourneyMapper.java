package com.parser.service.mapper;

import com.parser.dto.TourneyDto;
import com.parser.model.entity.Tourney;
import com.parser.model.repository.InformationRepository;
import com.parser.model.repository.SportRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
@Data
public class TourneyMapper {
    private ModelMapper modelMapper;

    public Tourney toEntity(TourneyDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Tourney.class);
    }

    public TourneyDto toDto(Tourney entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, TourneyDto.class);
    }

    public List<TourneyDto> listToDto(List<Tourney> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<TourneyDto>>() {
        }.getType());
    }

}

