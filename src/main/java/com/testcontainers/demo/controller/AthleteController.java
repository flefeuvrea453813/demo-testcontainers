package com.testcontainers.demo.controller;

import com.testcontainers.demo.dto.AthleteBody;
import com.testcontainers.demo.dto.AthleteDto;
import com.testcontainers.demo.service.AthleteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "AthleteController", description = "Controller pour faire du CRUD sur la table athlete")
@RequestMapping("/athlete")
public class AthleteController {

    private AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    @Operation(summary = "Get all athletes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server")})
    public ResponseEntity<List<AthleteDto>> getAllAthletes() {
        return ResponseEntity.status(HttpStatus.OK.value()).body(athleteService.getAllAthletes());
    }


    @GetMapping(value = "/{id}")
    @Operation(summary = "Get athlete by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server")})
    public ResponseEntity<AthleteDto> getAthlete(@PathVariable @NotNull final Long id) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(athleteService.getAthleteById(id));
    }


    @GetMapping("/surname/{surname}")
    @Operation(summary = "Get athletes by surname")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server")})
    public ResponseEntity<List<AthleteDto>> getAthletesBySurname(@PathVariable @NotBlank final String surname) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(athleteService.getAthletesBySurname(surname));
    }

    @GetMapping("/sport/{sport}")
    @Operation(summary = "Get athletes by sport")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server")})
    public ResponseEntity<List<AthleteDto>> getAthletesBySport(@PathVariable @NotBlank final String sport) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(athleteService.getAthletesBySport(sport));
    }

    @GetMapping("/country/{country}")
    @Operation(summary = "Get athletes by country")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server")})
    public ResponseEntity<List<AthleteDto>> getAthletesByCountry(@PathVariable @NotBlank final String country) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(athleteService.getAthletesByCountry(country));
    }

    @PostMapping
    @Operation(summary = "Create an athlete")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server")})
    public ResponseEntity createAthlete(@Valid @RequestBody AthleteBody athleteBody) {
        AthleteDto athleteDto = athleteService.createAthlete(athleteBody);
        return ResponseEntity.status(HttpStatus.CREATED.value()).header("uri", "/athlete/" + athleteDto.getId()).build();
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an athlete")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server")})
    public ResponseEntity deleteAthlete(@PathVariable @NotNull final Long id) {
        athleteService.deleteAthlete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update an athlete")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server")})
    public ResponseEntity<AthleteDto> updateAthlete(@PathVariable @NotNull final Long id, @Valid @RequestBody AthleteBody athleteBody) {
        AthleteDto athleteDto = athleteService.updateAthlete(id, athleteBody);
        return ResponseEntity.status(HttpStatus.OK.value()).body(athleteDto);
    }
}