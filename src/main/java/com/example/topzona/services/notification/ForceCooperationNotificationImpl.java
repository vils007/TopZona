package com.example.topzona.services.notification;

import com.example.topzona.entities.EventEntity;
import com.example.topzona.entities.EventName;
import com.example.topzona.entities.ResultType;
import com.example.topzona.repositories.EventsRepository;
import com.example.topzona.repositories.PrisonersRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ForceCooperationNotificationImpl implements Notification {

    EventsRepository eventsRepository;
    PrisonersRepository prisonersRepository;

    @Override
    public EventName getType() {
        return EventName.FORCE_COOPERATION;
    }

    @Override
    @Transactional
    public ResultType sendEvent(EventName eventName, UUID prisonerId, Integer cellId, UUID guardId) {
        Boolean isCooperation = new Random().nextBoolean();
        var prisoner= prisonersRepository.getReferenceById(prisonerId);
        prisoner.setIsCooperation(isCooperation);
        return eventsRepository.saveAndFlush(
                        new EventEntity(
                                UUID.randomUUID(),
                                eventName,
                                prisonerId,
                                cellId,
                                guardId,
                                isCooperation ? ResultType.PRISONER_START_COOPERATION : ResultType.PRISONER_DO_NOT_START_COOPERATION))
                .getResult();
    }
}
