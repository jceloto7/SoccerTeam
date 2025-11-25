package com.jceloto7.games_service.games.model;

import com.jceloto7.shared_model.model.Team;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Team team1;
    private Team team2;
    private String name;
    private String result;
    private String scoreboard;
    private String status;
}
