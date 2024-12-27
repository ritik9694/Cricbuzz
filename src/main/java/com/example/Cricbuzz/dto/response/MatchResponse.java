package com.example.Cricbuzz.dto.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MatchResponse {

    String title;

    String venue;

    Date created;

    List<TeamResponse> teams;
}
