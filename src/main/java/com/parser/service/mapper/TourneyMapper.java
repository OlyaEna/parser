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
    private InformationRepository informationRepository;

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

//
//    @PostConstruct
//    public void setupMapper() {
//        modelMapper.createTypeMap(Tourney.class, TourneyDto.class)
//                .addMappings(m -> m.skip(TourneyDto::setInformation)).setPostConverter(toDtoConverter());
//        modelMapper.createTypeMap(TourneyDto.class, Tourney.class)
//                .addMappings(m -> m.skip(Tourney::setInformation)).setPostConverter(toEntityConverter());
//    }
//
//    public Converter<TourneyDto, Tourney> toEntityConverter() {
//        return context -> {
//            TourneyDto source = context.getSource();
//            Tourney destination = context.getDestination();
//            mapSpecificFields(source, destination);
//            return context.getDestination();
//        };
//    }
//
//    public Converter<Tourney, TourneyDto> toDtoConverter() {
//        return context -> {
//            Tourney source = context.getSource();
//            TourneyDto destination = context.getDestination();
//            mapSpecificFields(source, destination);
//            return context.getDestination();
//        };
//    }
//
//
//    public void mapSpecificFields(Tourney source, TourneyDto destination) {
//        destination.setInformation(Objects.isNull(source) || Objects.isNull(source.getSport()) ? null : source.getInformation().getId());
//    }
//
//    void mapSpecificFields(TourneyDto source, Tourney destination) {
//        destination.setInformation(informationRepository.findById(source.getInformation()).orElse(null));
//    }
}

