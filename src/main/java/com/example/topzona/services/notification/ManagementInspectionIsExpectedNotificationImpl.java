package com.example.topzona.services.notification;

import com.example.topzona.entities.EventEntity;
import com.example.topzona.entities.EventName;
import com.example.topzona.entities.ResultType;
import com.example.topzona.repositories.EventsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ManagementInspectionIsExpectedNotificationImpl implements Notification {

    EventsRepository repository;

    @Override
    public EventName getType() {
        return EventName.MANAGEMENT_INSPECTION_IS_EXPECTED;
    }

    @Override
    public ResultType sendEvent(EventName eventName, UUID prisonerId, Integer cellId, UUID guardId) {
        return repository.saveAndFlush(new EventEntity(UUID.randomUUID(), eventName, prisonerId, cellId, guardId, ResultType.GUARDS_IS_SCARED)).getResult();
    }
}
