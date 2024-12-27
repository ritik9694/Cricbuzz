package com.example.Cricbuzz.converter;

import com.example.Cricbuzz.dto.request.MatchRequest;
import com.example.Cricbuzz.dto.response.MatchResponse;
import com.example.Cricbuzz.dto.response.TeamResponse;
import com.example.Cricbuzz.model.CricketMatch;

import java.util.ArrayList;
import java.util.List;

public class MatchConverter {

    public static CricketMatch matchRequestToMatch(MatchRequest matchRequest) {
        return CricketMatch.builder()
                .title(matchRequest.getTitle())
                .venue(matchRequest.getVenue())
                .teams(new ArrayList<>())
                .build();
    }

    public static MatchResponse matchToResponse(CricketMatch match) {

        List<TeamResponse> teams = new ArrayList<>();
        teams.add(TeamConverter.teamToTeamResponse(match.getTeams().get(0)));
        teams.add(TeamConverter.teamToTeamResponse(match.getTeams().get(1)));

        return MatchResponse.builder()
                .title(match.getTitle())
                .venue(match.getVenue())
                .created(match.getCreated())
                .teams(teams)
                .build();
    }
}
