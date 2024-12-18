package com.example.Cricbuzz.service;

import com.example.Cricbuzz.converter.StatsConverter;
import com.example.Cricbuzz.dto.request.StatsRequest;
import com.example.Cricbuzz.dto.response.StatsResponse;
import com.example.Cricbuzz.exception.PlayerNotFoundException;
import com.example.Cricbuzz.model.Player;
import com.example.Cricbuzz.model.Stats;
import com.example.Cricbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Stack;

@Service
public class StatsService {

    @Autowired
    PlayerRepository playerRepository;

    public StatsResponse addStats(StatsRequest statsRequest,
                                  int playerId) {
        //check player id is correct or not
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()){
            throw new PlayerNotFoundException("Invalid player id");
        }
        Player player = optionalPlayer.get();

        Stats stats = StatsConverter.statsRequestToStats(statsRequest);
        player.setStats(stats);
        stats.setPlayer(player);

        Player savedPlayer=playerRepository.save(player); //saves both player and stats

        return StatsConverter.statsToStatsResponse(savedPlayer.getStats());
    }
}
