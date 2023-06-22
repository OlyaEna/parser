package com.parser.controllers;

import com.parser.exceptions.ExceptionResponse;
import com.parser.exceptions.NoTourneyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoTourneyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse catchNoTourneyException(NoTourneyException exception) {
        return new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
    }


}