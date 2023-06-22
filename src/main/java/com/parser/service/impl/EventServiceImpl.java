package com.parser.service.impl;

import com.parser.dto.EventDto;
import com.parser.model.entity.Event;
import com.parser.model.repository.EventRepository;
import com.parser.service.EventService;
import com.parser.service.mapper.EventMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public EventDto save(EventDto eventDto) {
        Event event = eventRepository.save(eventMapper.toEntity(eventDto));
        return eventMapper.toDto(event);
    }

    @Override
    public List<EventDto> findEventsByTourneyId(Long id) {
        return eventMapper.listToDto(eventRepository.findAllEventsByTourney(id));

    }
}
