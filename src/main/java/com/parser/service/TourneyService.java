package com.parser.service;

import com.parser.dto.TourneyDto;

import java.util.List;

public interface TourneyService {
    TourneyDto save(TourneyDto tourneyDto);

    List<TourneyDto> findByTheLastInsert();

    List<TourneyDto> findTourneyBySportId(Long id);
    TourneyDto findById(Long id);

    List<TourneyDto> findTourneysById(Long id);

}
