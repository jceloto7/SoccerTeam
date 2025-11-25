package com.jceloto7.teams_service.teams.service;

import com.jceloto7.teams_service.teams.model.Team;
import com.jceloto7.teams_service.teams.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final TeamRepository teamRepository;

    public Team createTeam(Team team) {
        log.info("Criando novo time: {}", team.getName());
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        log.debug("Buscando todos os times cadastrados");
        return teamRepository.findAll();
    }

/*
    public Team getTeamById(Long id) {
        log.debug("Buscando time pelo id: {}", id);
        return teamRepository.findById(id)
                .orElse(null);
    }
*/
    public Team updateTeam(Long id, Team updated) {
        log.info("Atualizando time id={} com novos dados", id);
        return teamRepository.findById(id).map(team -> {
            team.setName(updated.getName());
            team.setCity(updated.getCity());
            team.setCoach(updated.getCoach());
            return teamRepository.save(team);
        }).orElse(null);
    }

    public boolean deleteTeam(Long id) {
        log.warn("Deletando time id={}", id);
        return teamRepository.findById(id).map(team -> {
            teamRepository.delete(team);
            return true;
        }).orElse(false);
    }
}
