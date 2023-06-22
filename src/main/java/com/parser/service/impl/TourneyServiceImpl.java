package com.parser.service.impl;

import com.parser.dto.InformationDto;
import com.parser.dto.SportDto;
import com.parser.dto.TourneyDto;
import com.parser.model.entity.Information;
import com.parser.model.entity.Sport;
import com.parser.model.entity.Tourney;
import com.parser.model.repository.TourneyRepository;
import com.parser.service.TourneyService;
import com.parser.service.mapper.InformationMapper;
import com.parser.service.mapper.SportMapper;
import com.parser.service.mapper.TourneyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TourneyServiceImpl implements TourneyService {
    private final TourneyRepository tourneyRepository;
    private final TourneyMapper tourneyMapper;

    @Override
    public TourneyDto save(TourneyDto tourneyDto) {
        Tourney tourney = tourneyRepository.save(tourneyMapper.toEntity(tourneyDto));
        return tourneyMapper.toDto(tourney);
    }

    @Override
    public List<TourneyDto> findByTheLastInsert() {
        List<Tourney> tourneyList = tourneyRepository.findByTheLastInsert();
        return tourneyMapper.listToDto(tourneyList);
    }

    public List<TourneyDto> findTourneyBySportId(Long id) {
        return tourneyMapper.listToDto(tourneyRepository.findTourneyBySportId(id));
    }

    @Override
    public TourneyDto findById(Long id) {
        return tourneyMapper.toDto(tourneyRepository.getReferenceById(id));
    }

    @Override
    public List<TourneyDto> findTourneysById(Long id) {
        return tourneyMapper.listToDto(tourneyRepository.findTourneysById(id));
    }


}
