package com.parser.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode
public class EventDto {
    private String  name;
    private String url;
    private LocalTime time;
    private TourneyDto tourney;
}
