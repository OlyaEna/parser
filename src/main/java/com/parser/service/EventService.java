package com.parser.service;

import com.parser.dto.EventDto;

import java.util.List;

public interface EventService {
    EventDto save(EventDto eventDto);
    List<EventDto> findEventsByTourneyId(Long id);

}
