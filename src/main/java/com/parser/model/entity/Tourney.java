package com.parser.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tourney")
public class Tourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Sport sport;
    private String url;
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Event> events;
}
