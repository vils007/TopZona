package com.example.topzona.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequisitesDTO {

    UUID id;
    String state;
    String region;
    String city;
    String address;
    String name;
}
