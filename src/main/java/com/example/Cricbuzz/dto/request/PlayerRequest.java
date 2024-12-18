package com.example.Cricbuzz.dto.request;

import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Enum.Speciality;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerRequest {

    String name;

    int age;

    Speciality speciality;

    Gender gender;
}
