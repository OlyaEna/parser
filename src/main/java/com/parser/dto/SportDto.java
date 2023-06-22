package com.parser.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode

public class SportDto {
    private Long id;
    private String  name;
    private String url;
//    private List<TourneyDto> tourneys;
}
