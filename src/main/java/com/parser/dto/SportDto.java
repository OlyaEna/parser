package com.parser.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode

public class SportDto {
    private Long id;
    private String  name;
    private String url;
}
