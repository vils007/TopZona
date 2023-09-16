package com.example.topzona.services;

import com.example.topzona.convectors.RequisitesDTOConvector;
import com.example.topzona.dto.RequisitesDTO;
import com.example.topzona.entities.RequisitesEntity;
import com.example.topzona.repositories.RequisitesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class RequisitesServiceTest {

    @Mock
    RequisitesRepository repository;

    @Spy
    RequisitesDTOConvector convector;

    @InjectMocks
    RequisitesService service;

    @Test
    @DisplayName("RequisitesService getRequisites return not null requisitesDTO and correct result")
    void getRequisites_ReturnsValidResultDTO() {

        UUID uuid = UUID.randomUUID();
        String state = "state";
        String region = "region";
        String city = "city";
        String address = "address";
        String name = "name";

        RequisitesDTO requisitesDTO = new RequisitesDTO(uuid, state, region, city, address, name);
        RequisitesEntity requisitesEntity = new RequisitesEntity(uuid, state, region, city, address, name);

        doReturn(requisitesEntity).when(this.repository).getReferenceById(uuid);

        var result = service.getRequisites(uuid);

        assertNotNull(result);
        assertEquals(result, requisitesDTO);
    }

    @Test
    @DisplayName("RequisitesService createOrUpdateRequisites save correct")
    void createOrUpdateRequisites_createRequisites(){

        var uuid = Optional.of(UUID.randomUUID());
        var state =  "state";
        var region = "region";
        var city = "city";
        var address = "address";
        var name = "name";
        RequisitesDTO requisitesDTO = new RequisitesDTO(uuid.get(), state, region, city, address, name);
        RequisitesEntity requisitesEntity = new RequisitesEntity(uuid.get(), null, null, null, null, null);

        doReturn(requisitesEntity).when(this.repository).getReferenceById(uuid.get());
        requisitesEntity.setState(state);
        requisitesEntity.setRegion(region);
        requisitesEntity.setCity(city);
        requisitesEntity.setAddress(address);
        requisitesEntity.setName(name);

        doReturn(requisitesEntity).when(this.repository).saveAndFlush(requisitesEntity);

        var result = service.createOrUpdateRequisites(uuid, Optional.of(state), Optional.of(region), Optional.of(city), Optional.of(address), Optional.of(name));
        assertNotNull(result);
        assertEquals(result, requisitesDTO);
    }
}