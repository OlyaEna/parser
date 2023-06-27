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
}

