package com.parser.service.mapper;

import com.parser.dto.SportDto;
import com.parser.model.entity.Sport;
import com.parser.model.repository.SportRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
@Data
public class SportMapper {
    private ModelMapper modelMapper;

    public Sport toEntity(SportDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Sport.class);
    }

    public SportDto toDto(Sport entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, SportDto.class);
    }

    public List<SportDto> listToDto(List<Sport> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<SportDto>>() {
        }.getType());
    }
}
