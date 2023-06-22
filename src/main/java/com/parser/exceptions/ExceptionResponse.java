package com.parser.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private LocalDateTime date;

    public ExceptionResponse(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.date = localDateTime;
    }

}