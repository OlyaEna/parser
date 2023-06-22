package com.parser.service;

import java.io.IOException;

public interface ParserService {
    public void getAllSports() throws IOException;
    public void getAllTourneys() throws IOException;
    public void getAllEvents() throws IOException;
}
