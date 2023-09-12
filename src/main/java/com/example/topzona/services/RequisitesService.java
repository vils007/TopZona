package com.example.topzona.services;


import com.example.topzona.convectors.RequisitesDTOConvector;
import com.example.topzona.dto.RequisitesDTO;
import com.example.topzona.entities.RequisitesEntity;
import com.example.topzona.repositories.RequisitesRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequisitesService {
    RequisitesRepository repository;
    RequisitesDTOConvector convector;

    public RequisitesDTO getRequisites(UUID uuid) {
        return convector.makeRequisitesDTO(repository.getReferenceById(uuid));
    }

    @Transactional
    public List<RequisitesDTO> findRequisitesByName(Optional<String> optionalName) {

        Stream<RequisitesEntity> projectStream = optionalName
                .map(repository::streamAllByNameStartsWithIgnoreCase)
                .orElseGet(repository::streamAllBy);

        return projectStream
                .map(convector::makeRequisitesDTO)
                .collect(Collectors.toList());
    }


    public RequisitesDTO createOrUpdateRequisites(Optional<UUID> id, Optional<String> state, Optional<String> region, Optional<String> city, Optional<String> address, Optional<String> name) {

        AtomicReference<RequisitesEntity> requisitesEntity = new AtomicReference<>(new RequisitesEntity());

        id.ifPresentOrElse((uuid) -> requisitesEntity.set(repository.getReferenceById(uuid)),
                () -> requisitesEntity.get().setId(UUID.randomUUID()));

        name.ifPresentOrElse(requisitesEntity.get()::setName,
                () -> requisitesEntity.get().setName(null));
        state.ifPresentOrElse(requisitesEntity.get()::setState,
                () -> requisitesEntity.get().setState(null));
        region.ifPresentOrElse(requisitesEntity.get()::setRegion,
                () -> requisitesEntity.get().setRegion(null));
        city.ifPresentOrElse(requisitesEntity.get()::setCity,
                () -> requisitesEntity.get().setCity(null));
        address.ifPresentOrElse(requisitesEntity.get()::setAddress,
                () -> requisitesEntity.get().setAddress(null));

        return convector.makeRequisitesDTO(repository.saveAndFlush(requisitesEntity.get()));
    }


    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }
}