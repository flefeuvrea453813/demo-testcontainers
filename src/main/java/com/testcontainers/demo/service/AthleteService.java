package com.testcontainers.demo.service;

import com.testcontainers.demo.dto.AthleteBody;
import com.testcontainers.demo.dto.AthleteDto;

import java.util.List;


public interface AthleteService {
    /**
     * Méthode récupérant tous les athlètes.
     * @return la liste de tous athletes
     */
    List<AthleteDto> getAllAthletes();

    AthleteDto getAthleteById(final Long id);

    List<AthleteDto> getAthletesBySurname(final String surname);

    List<AthleteDto> getAthletesBySport(final String sport);

    List<AthleteDto> getAthletesByCountry(final String country);

    AthleteDto createAthlete(final AthleteBody athleteBody);

    AthleteDto updateAthlete(final Long id, final AthleteBody athleteBody);

    void deleteAthlete(final Long id);
}
