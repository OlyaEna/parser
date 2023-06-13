package com.parser.service.impl;

import com.parser.model.repository.EventRepository;
import com.parser.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
}
