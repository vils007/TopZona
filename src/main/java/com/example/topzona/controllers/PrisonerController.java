package com.example.topzona.controllers;


import com.example.topzona.dto.PrisonerDTO;
import com.example.topzona.entities.PrisonerType;
import com.example.topzona.services.PrisonersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prisoner")
public class PrisonerController {


    private final PrisonersService service;

    @PostMapping("/create")
    public ResponseEntity<PrisonerDTO> createRandomPrisoner(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "nicName") String nicName,
            @RequestParam(value = "prisonerType") PrisonerType prisonerType) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.createRandomPrisoner(name, nicName, prisonerType));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PrisonerDTO>> getAllPrisoners(){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getAll());
    }

}
