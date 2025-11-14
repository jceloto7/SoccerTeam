package com.jceloto7.teams_service.teams.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jceloto7.teams_service.teams.model.Team;
import com.jceloto7.teams_service.teams.service.TeamService;
import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
@Slf4j
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        log.info("Recebida requisição para criar time: {}", team.getName());
        return ResponseEntity.ok(teamService.createTeam(team));
    }

    @GetMapping
    public ResponseEntity<List<Team>> listTeams() {
        log.info("Recebida requisição para listar times");
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team team) {
        log.info("Recebida requisição para atualizar time ID {}: {}", id, team.getName());
        return ResponseEntity.ok(teamService.updateTeam(id, team));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        log.info("Recebida requisição para deletar time ID {}", id);
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}