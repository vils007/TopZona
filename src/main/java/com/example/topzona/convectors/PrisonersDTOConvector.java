package com.example.topzona.convectors;

import com.example.topzona.dto.PrisonerDTO;
import com.example.topzona.entities.PrisonerEntity;
import org.springframework.stereotype.Component;

@Component
public class PrisonersDTOConvector {

    public PrisonerDTO makePrisonerDTO(PrisonerEntity entity) {
        return PrisonerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cell(entity.getCell())
                .aggression(entity.getAggression())
                .health(entity.getHealth())
                .isCooperation(entity.getIsCooperation())
                .nicName(entity.getNicName())
                .type(entity.getType())
                .build();
    }


}
