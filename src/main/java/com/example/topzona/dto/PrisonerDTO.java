package com.example.topzona.dto;

import com.example.topzona.entities.CellEntity;
import com.example.topzona.entities.HealthType;
import com.example.topzona.entities.PrisonerType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrisonerDTO {

    UUID id;
    String name;
    String nicName;
    PrisonerType type;
    CellEntity cell;
    Integer aggression;
    HealthType health;
    Boolean isCooperation;
}
