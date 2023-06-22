package com.parser.service.impl;

import com.parser.dto.SportDto;
import com.parser.dto.TourneyDto;
import com.parser.model.entity.Sport;
import com.parser.model.repository.SportRepository;
import com.parser.service.SportService;
import com.parser.service.TourneyService;
import com.parser.service.mapper.SportMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SportServiceImpl implements SportService {
    private final SportRepository sportRepository;
    private final SportMapper sportMapper;
    private final TourneyService tourneyService;

    @Override
    public List<SportDto> findAll() {
        return sportMapper.listToDto(sportRepository.findAll());
    }

    @Override
    public SportDto save(SportDto sportDto) {
        Sport sport = sportRepository.save(sportMapper.toEntity(sportDto));
        return sportMapper.toDto(sport);
    }

    @Override
    public Set<SportDto> findAllSportsByTourney() {
        Set<SportDto> sports = new HashSet<>();
        List<TourneyDto> tourneys = tourneyService.findByTheLastInsert();
        for (TourneyDto tourney : tourneys) {
            sports.add(tourney.getSport());
        }
        return sports;
    }

    @Override
    public SportDto findById(Long id) {
        return sportMapper.toDto(sportRepository.getReferenceById(id));
    }
}
