package com.example.topzona.controllers;

import com.example.topzona.dto.CellDTO;
import com.example.topzona.entities.CellsType;
import com.example.topzona.services.CellsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cell")
public class CellController {

    private final CellsService service;

    @PostMapping("/createOrUpdate")
    public ResponseEntity<CellDTO> createOrUpdateCell(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "capacity") int capacity,
            @RequestParam(value = "cellType") CellsType cellType) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.createOrUpdateCell(id, capacity, cellType));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CellDTO>> getAllCells() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getAll());
    }
}
