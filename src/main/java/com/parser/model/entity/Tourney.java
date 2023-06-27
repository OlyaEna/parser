package com.parser.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tourney")
public class Tourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Sport sport;
    private String url;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Information information;
}
