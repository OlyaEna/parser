package com.parser.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private LocalTime time;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Tourney tourney;

}
