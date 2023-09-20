package com.example.topzona.dto;

import com.example.topzona.entities.CellsType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CellDTO {
    int id;
    int capacity;
    CellsType type;
}
