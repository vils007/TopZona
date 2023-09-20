package com.example.topzona.services.notification;

import com.example.topzona.entities.EventEntity;
import com.example.topzona.entities.EventName;
import com.example.topzona.entities.ResultType;
import com.example.topzona.repositories.CellsRepository;
import com.example.topzona.repositories.EventsRepository;
import com.example.topzona.repositories.PrisonersRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransferToCellNotificationImpl implements Notification {

    EventsRepository eventsRepository;
    PrisonersRepository prisonersRepository;
    CellsRepository cellsRepository;

    @Override
    public EventName getType() {
        return EventName.TRANSFER_TO_CELL;
    }

    @Override
    @Transactional
    public ResultType sendEvent(EventName eventName, UUID prisonerId, Integer cellId, UUID guardId) {
        var cell = cellsRepository.getReferenceById(cellId);
        prisonersRepository.getReferenceById(prisonerId).setCell(cell);
        return eventsRepository.saveAndFlush(new EventEntity(UUID.randomUUID(), eventName, prisonerId, cellId, guardId, ResultType.PRISONER_TRANSFERRED)).getResult();
    }
}
