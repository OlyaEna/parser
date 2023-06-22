package com.parser.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode

public class InformationDto {
    private Long id;
    private LocalDateTime createdAt;
}
