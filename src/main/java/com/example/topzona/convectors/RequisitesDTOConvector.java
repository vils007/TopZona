package com.example.topzona.convectors;

import com.example.topzona.dto.RequisitesDTO;
import com.example.topzona.entities.RequisitesEntity;
import org.springframework.stereotype.Component;

@Component
public class RequisitesDTOConvector {

    public RequisitesDTO makeRequisitesDTO(RequisitesEntity entity) {

        return RequisitesDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .city(entity.getCity())
                .region(entity.getRegion())
                .state(entity.getState())
                .build();
    }

}
