package com.parser.dto;

import com.parser.model.entity.Sport;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TourneyDto {
    private Long id;
    private String name;
    private SportDto sport;
    private String url;
    private InformationDto information;
}
