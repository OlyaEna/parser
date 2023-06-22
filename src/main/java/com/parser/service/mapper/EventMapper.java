package com.parser.service.mapper;

import com.parser.dto.EventDto;
import com.parser.model.entity.Event;
import com.parser.model.repository.TourneyRepository;
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
public class EventMapper {
    private ModelMapper modelMapper;
    private final TourneyRepository tourneyRepository;


    public Event toEntity(EventDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Event.class);
    }

    public EventDto toDto(Event entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, EventDto.class);
    }

    public List<EventDto> listToDto(List<Event> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<EventDto>>() {
        }.getType());
    }

//
//    @PostConstruct
//    public void setupMapper() {
//        modelMapper.createTypeMap(Event.class, EventDto.class)
//                .addMappings(m -> m.skip(EventDto::setTourney)).setPostConverter(toDtoConverter());
//        modelMapper.createTypeMap(EventDto.class, Event.class)
//                .addMappings(m -> m.skip(Event::setTourney)).setPostConverter(toEntityConverter());
//    }
//
//    public Converter<EventDto, Event> toEntityConverter() {
//        return context -> {
//            EventDto source = context.getSource();
//            Event destination = context.getDestination();
//            mapSpecificFields(source, destination);
//            return context.getDestination();
//        };
//    }
//
//    public Converter<Event, EventDto> toDtoConverter() {
//        return context -> {
//            Event source = context.getSource();
//            EventDto destination = context.getDestination();
//            mapSpecificFields(source, destination);
//            return context.getDestination();
//        };
//    }
//
//
//    public void mapSpecificFields(Event source, EventDto destination) {
//        destination.setTourney(Objects.isNull(source) || Objects.isNull(source.getTourney()) ? null : source.getTourney().getName());
//    }
//
//    void mapSpecificFields(EventDto source, Event destination) {
//        destination.setTourney(tourneyRepository.findByName(source.getTourney()).orElse(null));
//    }
}

