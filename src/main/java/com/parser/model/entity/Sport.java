package com.parser.model.entity;

import jakarta.persistence.*;
import lombok.Data;;

@Data
@Entity
@Table(name = "sport")
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    private String url;
}
