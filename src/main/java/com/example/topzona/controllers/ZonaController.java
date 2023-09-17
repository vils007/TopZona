package com.example.topzona.controllers;

import com.example.topzona.dto.RequisitesDTO;
import com.example.topzona.services.RequisitesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/zona")
public class ZonaController {

    private final RequisitesService service;

    public static final String API_REQUISITES = "/requisites";

    /**
     * Метод для получения реквезитов колонии.
     *
     * @param: uuid колонии.
     * @return: данные реквезитов колонии.
     */
    @GetMapping(value = API_REQUISITES + "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RequisitesDTO> getRequisites(@RequestParam(value = "id") String uuid) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getRequisites(UUID.fromString(uuid)));
    }

    /**
     * Метод для получения реквезитов колонии по имени.
     *
     * @param: Name колонии.
     * @return: данные реквезитов колонии.
     */
    @GetMapping(API_REQUISITES + "/name")
    public ResponseEntity<List<RequisitesDTO>> findRequisitesByName(
            @RequestParam(value = "name", required = false) Optional<String> optionalName) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findRequisitesByName(optionalName));
    }


    /**
     * Метод создания или изменения реквизитов колонии.
     *
     * @param: UUID id
     * @param: String state
     * @param: String region
     * @param: String city
     * @param: String address
     * @param: String name
     * @return: данные реквезитов колонии.
     */
    @PostMapping(API_REQUISITES)
    public ResponseEntity<RequisitesDTO> createOrUpdateRequisites(
            @RequestParam(value = "id", required = false) Optional<UUID> id,
            @RequestParam(value = "state", required = false) Optional<String> state,
            @RequestParam(value = "region", required = false) Optional<String> region,
            @RequestParam(value = "city", required = false) Optional<String> city,
            @RequestParam(value = "address", required = false) Optional<String> address,
            @RequestParam(value = "name", required = false) Optional<String> name) {

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.createOrUpdateRequisites(id, state, region, city, address, name));
    }

    /**
     * Метод удаления реквизитов колонии по id.
     *
     * @param: UUID id
     */
    @DeleteMapping(API_REQUISITES)
    public void deleteProject(@RequestParam(value = "id") UUID uuid) {
        service.deleteById(uuid);
    }

}
