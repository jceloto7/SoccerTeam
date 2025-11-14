package com.jceloto7.teams_service.teams.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String coach;
    private String stadium;
}