package com.parser.service;

import com.parser.dto.InformationDto;
import com.parser.model.entity.Information;

public interface InformationService {
    public Information save(InformationDto informationDto);
    InformationDto toDto(Information information);
}
