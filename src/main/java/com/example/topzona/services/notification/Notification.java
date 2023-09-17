package com.example.topzona.services.notification;

import com.example.topzona.entities.EventName;
import com.example.topzona.entities.ResultType;

import java.util.Optional;
import java.util.UUID;

public interface Notification {
    EventName getType();

    ResultType sendEvent(EventName eventName, UUID prisonerId, Integer cellId, UUID guardId);
}
