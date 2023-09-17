package com.example.topzona.convectors;

import com.example.topzona.dto.CellDTO;
import com.example.topzona.entities.CellEntity;
import org.springframework.stereotype.Component;

@Component
public class CellDTOConvector {

    public CellDTO makeCellDTO(CellEntity entity) {
        return CellDTO.builder()
                .id(entity.getId())
                .capacity(entity.getCapacity())
                .type(entity.getType())
                .build();
    }
}
