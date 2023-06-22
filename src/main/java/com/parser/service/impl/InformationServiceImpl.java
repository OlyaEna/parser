package com.parser.service.impl;

import com.parser.dto.InformationDto;
import com.parser.model.entity.Information;
import com.parser.model.repository.InformationRepository;
import com.parser.service.InformationService;
import com.parser.service.mapper.InformationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InformationServiceImpl implements InformationService {
    private final InformationRepository informationRepository;
    private final InformationMapper informationMapper;
    @Override
    public Information save(InformationDto informationDto){
        Information information =  informationRepository.save(informationMapper.toEntity(informationDto));
        return information;
    }

    public InformationDto toDto(Information information){
        return informationMapper.toDto(information);
    }
}
