package com.parser.service.impl;

import com.parser.model.repository.TourneyRepository;
import com.parser.service.TourneyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TourneyServiceImpl implements TourneyService {
    private final TourneyRepository tourneyRepository;
}
