package com.parser.controllers;

import com.parser.dto.EventDto;
import com.parser.dto.SportDto;
import com.parser.dto.TourneyDto;
import com.parser.service.EventService;
import com.parser.service.SportService;
import com.parser.service.TourneyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class ParserController {
    private final TourneyService tourneyService;
    private final SportService sportService;
    private final EventService eventService;


    @GetMapping("/all")
    public String allSport(Model model) {
        Set<SportDto> sports = sportService.findAllSportsByTourney();
        model.addAttribute("sports", sports);
        return "main";
    }

    @GetMapping("/sport/{id}")
    public String allTourneys(@PathVariable("id") Long id, Model model) {
        Set<SportDto> sports = sportService.findAllSportsByTourney();
        model.addAttribute("sports", sports);

        SportDto sport = sportService.findById(id);
        model.addAttribute("sport", sport);

        List<TourneyDto> tourneys = tourneyService.findTourneyBySportId(id);
        model.addAttribute("tourneys", tourneys);
        return "tourney";
    }

    @GetMapping("/tourney/{id}")
    public String allEvents(@PathVariable("id") Long id, Model model) {
        List<TourneyDto> tourneys = tourneyService.findTourneysById(id);
        model.addAttribute("tourneys", tourneys);

        TourneyDto tourney = tourneyService.findById(id);
        model.addAttribute("tourney", tourney);

        List<EventDto> events = eventService.findEventsByTourneyId(id);
        model.addAttribute("events", events);
        return "event";
    }
}
