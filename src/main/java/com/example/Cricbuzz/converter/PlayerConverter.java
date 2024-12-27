package com.example.Cricbuzz.converter;

import com.example.Cricbuzz.dto.request.PlayerRequest;
import com.example.Cricbuzz.dto.response.PlayerResponse;
import com.example.Cricbuzz.model.Player;


public class PlayerConverter {

    public static Player playerRequestToPlayer(PlayerRequest playerRequest){
        return Player.builder()
                .name(playerRequest.getName())
                .age(playerRequest.getAge())
                .speciality(playerRequest.getSpeciality())
                .gender(playerRequest.getGender())
                .email(playerRequest.getEmail())
                .build();
    }
    public static PlayerResponse playerToPlayerResponse(Player player){
        return PlayerResponse.builder()
                .name(player.getName())
                .speciality(player.getSpeciality())
                .build();
    }
}
