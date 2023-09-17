package com.example.topzona.services;


import com.example.topzona.entities.EventName;
import com.example.topzona.entities.ResultType;
import com.example.topzona.services.notification.Notification;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;


@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventsService {

    Map<EventName, Notification> notificationMap;

    public EventsService(List<Notification> notificationList) {
        this.notificationMap = notificationList.stream().collect(Collectors.toMap(Notification::getType, Function.identity()));
    }

    public ResultType sendEvent(EventName eventName, UUID prisonerId, Integer cellId, UUID guardId) {
        return notificationMap.get(eventName).sendEvent(eventName, prisonerId, cellId, guardId);
    }
}
