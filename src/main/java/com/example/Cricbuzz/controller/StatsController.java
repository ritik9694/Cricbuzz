package com.example.Cricbuzz.controller;

import com.example.Cricbuzz.dto.request.StatsRequest;
import com.example.Cricbuzz.dto.response.StatsResponse;
import com.example.Cricbuzz.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsController {

    @Autowired
    StatsService statsService;

    public StatsResponse addStats(@RequestBody StatsRequest statsRequest,
                                  @RequestBody("player-id") int playerId){ //connect stats to player id
        return statsService.addStats(statsRequest,playerId);
    }
}
