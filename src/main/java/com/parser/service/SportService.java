package com.parser.service;

import com.parser.dto.SportDto;

import java.util.List;
import java.util.Set;

public interface SportService {
    List<SportDto> findAll();

    SportDto save(SportDto sportDto);

    Set<SportDto> findAllSportsByTourney();

    SportDto findById(Long id);
}
