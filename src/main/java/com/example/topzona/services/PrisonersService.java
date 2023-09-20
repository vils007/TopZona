package com.example.topzona.services;

import com.example.topzona.convectors.PrisonersDTOConvector;
import com.example.topzona.dto.PrisonerDTO;
import com.example.topzona.entities.HealthType;
import com.example.topzona.entities.PrisonerEntity;
import com.example.topzona.entities.PrisonerType;
import com.example.topzona.repositories.PrisonersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PrisonersService {

    PrisonersRepository repository;
    PrisonersDTOConvector convector;

    public PrisonerDTO createRandomPrisoner(String name, String nicName, PrisonerType prisonerType) {
        return convector.makePrisonerDTO(
                repository.saveAndFlush(
                        new PrisonerEntity(
                                UUID.randomUUID(),
                                name,
                                nicName,
                                prisonerType,
                                null,
                                10,
                                HealthType.GOOD,
                                false)));
    }

    public List<PrisonerDTO> getAll() {
        return repository.findAll()
                .stream().map(convector::makePrisonerDTO)
                .collect(Collectors.toList());
    }
}
