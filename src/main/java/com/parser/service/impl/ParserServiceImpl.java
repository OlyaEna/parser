package com.parser.service.impl;

import com.parser.dto.EventDto;
import com.parser.dto.InformationDto;
import com.parser.dto.SportDto;
import com.parser.dto.TourneyDto;
import com.parser.model.entity.Information;
import com.parser.service.*;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@AllArgsConstructor
@Service
@EnableScheduling
@PropertySource("classpath:values.properties")
public class ParserServiceImpl implements ParserService {
    private final TourneyService tourneyService;
    private final EventService eventService;
    private final SportService sportService;
    private final InformationService informationService;



    @Value("${parser.API.URL}")
    private final String API_URL;

    @Value("${parser.API.INTERVAL}")
    private final String API_INTERVAL;

    @Value("${parser.API.HTTP}")
    private final String API_HTTP;

    public void getAllSports() throws IOException {
        Document doc = Jsoup.connect(API_URL).get();
        Elements sportElements = doc.getElementsByAttributeValue("class", "sport-category-label");

        for (Element element : sportElements) {
            String names = element.getElementsByClass("sport-category-label").first().text();
            String detailsLink = element.attr("href");
            SportDto sport = new SportDto();
            sport.setName(names);
            sport.setUrl(API_HTTP + detailsLink + API_INTERVAL);
            sportService.save(sport);
        }
    }

    @Scheduled(fixedDelay = 60000)
    public void getAllTourneys() throws IOException {

        InformationDto informationDto = new InformationDto();
        Information information = informationService.save(informationDto);


        for (SportDto sport : sportService.findAll()) {
            Document document = Jsoup.connect(sport.getUrl()).get();
            Elements tourneyElements = document.getElementsByAttributeValue("class", "category-label-link");

            for (Element element : tourneyElements) {
                    String names = element.getElementsByClass("category-label").first().text();
                    String detailsLink = element.attr("href");
                    TourneyDto tourney = new TourneyDto();
                    tourney.setName(names);
                    tourney.setUrl(API_HTTP + detailsLink + API_INTERVAL);
                    tourney.setSport(sport);
                    tourney.setInformation(informationService.toDto(information));
                    tourneyService.save(tourney);

            }
        }
        getAllEvents();
    }


    public void getAllEvents() throws IOException {

        for (TourneyDto tourney : tourneyService.findByTheLastInsert()) {
            Document postDetailsDoc = Jsoup.connect(tourney.getUrl()).get();
            Elements eventElements = postDetailsDoc.getElementsByAttributeValue("class", "bg coupon-row");

            for (Element element : eventElements) {
                String names1 = element.attr("data-event-name");
                String detailsLink = element.getElementsByAttributeValue("class", "member-link").attr("href");
                String time = element.getElementsByClass("date date-short").first().text();
                EventDto event = new EventDto();
                event.setName(names1);
                event.setTime(parseTime(time));
                event.setUrl(API_HTTP + detailsLink);
                event.setTourney(tourney);
                eventService.save(event);
            }
        }
    }


    private LocalTime parseTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time, formatter);
    }


}





