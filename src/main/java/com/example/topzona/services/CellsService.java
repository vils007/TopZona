package com.example.topzona.services;

import com.example.topzona.convectors.CellDTOConvector;
import com.example.topzona.dto.CellDTO;
import com.example.topzona.entities.CellEntity;
import com.example.topzona.entities.CellsType;
import com.example.topzona.repositories.CellsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CellsService {

    CellsRepository repository;
    CellDTOConvector convector;

    public CellDTO createCell(int id, int capacity, CellsType cellType) {
        return convector.makeCellDTO(
                repository.saveAndFlush(
                        new CellEntity(
                                id,
                                capacity,
                                cellType)));
    }

    public List<CellDTO> getAll(){
        return repository.findAll()
                .stream().map(convector::makeCellDTO)
                .collect(Collectors.toList());
    }
}
