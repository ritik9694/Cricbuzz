package com.example.Cricbuzz.service;

import com.example.Cricbuzz.converter.MatchConverter;
import com.example.Cricbuzz.dto.request.MatchRequest;
import com.example.Cricbuzz.dto.response.MatchResponse;
import com.example.Cricbuzz.exception.TeamNotFoundException;
import com.example.Cricbuzz.model.CricketMatch;
import com.example.Cricbuzz.model.Team;
import com.example.Cricbuzz.repository.MatchRepoitory;
import com.example.Cricbuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepoitory matchRepoitory;

    public MatchResponse registerMatch(MatchRequest matchRequest, int teamAId, int teamBId) {
        Optional<Team> optionalTeamA = teamRepository.findById(teamAId);
        Optional<Team> optionalTeamB = teamRepository.findById(teamBId);

        if(optionalTeamA.isEmpty() || optionalTeamB.isEmpty()) {
            throw new TeamNotFoundException("one or more teams not found");
        }
        Team teamA = optionalTeamA.get();
        Team teamB = optionalTeamB.get();

        CricketMatch match = MatchConverter.matchRequestToMatch(matchRequest);
        match.getTeams().add(teamA);
        match.getTeams().add(teamB);

        teamA.setMatchesPlayed(teamA.getMatchesPlayed() + 1);
        teamA.getMatches().add(match);

        teamB.setMatchesPlayed(teamB.getMatchesPlayed() + 1);
        teamB.getMatches().add(match);

        CricketMatch savedMatch = matchRepoitory.save(match);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConverter.matchToResponse(savedMatch);
    }
}
