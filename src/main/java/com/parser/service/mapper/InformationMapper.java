package com.parser.service.mapper;

import com.parser.dto.InformationDto;
import com.parser.model.entity.Information;
import com.parser.model.repository.InformationRepository;
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
public class InformationMapper {
    private ModelMapper modelMapper;

    public Information toEntity(InformationDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Information.class);
    }

    public InformationDto toDto(Information entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, InformationDto.class);
    }

    public List<InformationDto> listToDto(List<Information> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<InformationDto>>() {
        }.getType());
    }
}
