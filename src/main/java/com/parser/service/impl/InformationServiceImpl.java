package com.parser.service.impl;

import com.parser.model.repository.InformationRepository;
import com.parser.service.InformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InformationServiceImpl implements InformationService {
    private final InformationRepository informationRepository;

}
