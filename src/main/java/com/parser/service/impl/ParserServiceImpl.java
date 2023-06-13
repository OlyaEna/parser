package com.parser.service.impl;

import com.parser.model.entity.Event;
import com.parser.model.entity.Sport;
import com.parser.model.entity.Tourney;
import com.parser.model.repository.EventRepository;
import com.parser.model.repository.SportRepository;
import com.parser.model.repository.TourneyRepository;
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
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@EnableScheduling
@PropertySource("classpath:values.properties")
public class ParserServiceImpl {
    private final SportRepository sportRepository;
    private final TourneyRepository tourneyRepository;
    private final EventRepository eventRepository;
    private final List<Sport> sports = new ArrayList<>();
    private final List<Tourney> tourneys = new ArrayList<>();


    private final String API_URL = "https://www.marathonbet.by/su/betting/?interval=H1";
    private final String API_INTERVAL = "?interval=H1";
    private final String API_HTTP = "https://www.marathonbet.by";


//
//    @Value("${parser.API.URL}")
//    private final String API_URL;

//    @Value("${parser.API.INTERVAL}")
//    private final String API_INTERVAL;

//    @Value("${parser.API.HTTP}")
//    private final String API_HTTP;

//
//    private String apiURIBuilder() {
//        return UriComponentsBuilder.fromHttpUrl(API_URL)
//                .replaceQueryParam("interval", API_INTERVAL)
//                .build()
//                .toString();
//    }


    @Scheduled(fixedDelay = 60000)
    public void parser() throws IOException {
//        Document doc = Jsoup.connect(apiURIBuilder()).get();

        Document doc = Jsoup.connect(API_URL).get();
        Elements sportElements = doc.getElementsByAttributeValue("class", "sport-category-label");
        for (Element element : sportElements) {
            String names = element.getElementsByClass("sport-category-label").first().text();
            String detailsLink = element.attr("href");
//            List<Sport> allSports= sportRepository.findAll();
            Sport sport = new Sport();
            sport.setName(names);
            sport.setUrl(API_HTTP + detailsLink + API_INTERVAL);
            sports.add(sport);
            sportRepository.save(sport);
        }


        for (Sport sportKind : sports) {
            Document document = Jsoup.connect(sportKind.getUrl()).get();
            Elements tourneyElements = document.getElementsByAttributeValue("class", "category-label-link");
            for (Element element : tourneyElements) {
                String names = element.getElementsByClass("category-label").first().text();
                String detailsLink = element.attr("href");
                Tourney tourney = new Tourney();
                tourney.setName(names);
                tourney.setUrl(API_HTTP + detailsLink + API_INTERVAL);
                tourney.setSport(sportKind);
                tourneys.add(tourney);
                tourneyRepository.save(tourney);
            }
        }

        for (Tourney tourney : tourneys) {
            Document postDetailsDoc = Jsoup.connect(tourney.getUrl()).get();
            Elements eventElements = postDetailsDoc.getElementsByAttributeValue("class", "bg coupon-row");
            for (Element element : eventElements) {
                String names1 = element.attr("data-event-name");
                String detailsLink = element.getElementsByAttributeValue("class", "member-link").attr("href");
                String time = element.getElementsByClass("date date-short").first().text();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime localtime = LocalTime.parse(time, formatter);
                Event event = new Event();
                event.setName(names1);
                event.setTime(localtime);
                event.setUrl(API_HTTP + detailsLink);
                event.setTourney(tourney);
                eventRepository.save(event);
            }
        }
    }
}





