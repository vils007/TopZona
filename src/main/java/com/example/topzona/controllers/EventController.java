package com.example.topzona.controllers;


import com.example.topzona.entities.EventName;
import com.example.topzona.entities.ResultType;
import com.example.topzona.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventsService service;
    private static final String API_EVENT = "/send";

    @PostMapping(API_EVENT)
    public ResponseEntity<ResultType> sendEvent(
            @RequestParam(value = "eventName", required = false) EventName eventName,
            @RequestParam(value = "prisonerId", required = false) UUID prisonerId,
            @RequestParam(value = "cellId", required = false) Integer cellId,
            @RequestParam(value = "guardId", required = false) UUID guardId) {

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.sendEvent(eventName, prisonerId, cellId, guardId));

    }
}
