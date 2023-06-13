package com.parser.service.impl;

import com.parser.model.repository.SportRepository;
import com.parser.service.SportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SportServiceImpl implements SportService {
    private final SportRepository sportRepository;
}
