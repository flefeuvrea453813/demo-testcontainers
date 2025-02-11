package com.testcontainers.demo.service.impl;

import com.testcontainers.demo.dto.AthleteBody;
import com.testcontainers.demo.dto.AthleteDto;
import com.testcontainers.demo.entity.AthleteEntity;
import com.testcontainers.demo.exception.ResourceNotFoundException;
import com.testcontainers.demo.repository.AthleteRepository;
import com.testcontainers.demo.service.AthleteService;
import com.testcontainers.demo.utils.Mapper;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@Data
@Service
public class AthleteServiceImpl implements AthleteService {

    private AthleteRepository athleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public List<AthleteDto> getAllAthletes() {
        return athleteRepository.findAll().stream().map(athleteEntity -> Mapper.mapAtheAthleteEntityToAthleteDto(athleteEntity)).collect(Collectors.toList());
    }

    @Override
    public AthleteDto getAthleteById(final Long id) {
        return athleteRepository.findById(id).map(athleteEntity -> Mapper.mapAtheAthleteEntityToAthleteDto(athleteEntity)).orElseThrow(() -> new ResourceNotFoundException("Pas d'athlète pour l'id " + id));
    }

    @Override
    public List<AthleteDto> getAthletesBySurname(final String surname) {
        return athleteRepository.findAllBySurname(surname).stream().map(athleteEntity -> Mapper.mapAtheAthleteEntityToAthleteDto(athleteEntity)).collect(Collectors.toList());
    }

    @Override
    public List<AthleteDto> getAthletesBySport(final String sport) {
        return athleteRepository.findAllBySport(sport).stream().map(athleteEntity -> Mapper.mapAtheAthleteEntityToAthleteDto(athleteEntity)).collect(Collectors.toList());
    }

    @Override
    public List<AthleteDto> getAthletesByCountry(final String country) {
        return athleteRepository.findAllByCountry(country).stream().map(athleteEntity -> Mapper.mapAtheAthleteEntityToAthleteDto(athleteEntity)).collect(Collectors.toList());
    }

    @Override
    public AthleteDto createAthlete(final AthleteBody athleteBody) {
        return Mapper.mapAtheAthleteEntityToAthleteDto(athleteRepository.saveAndFlush(Mapper.mapAtheAthleteBodyToAthleteEntity(athleteBody)));
    }

    @Override
    public AthleteDto updateAthlete(final Long id, final AthleteBody athleteBody) {
        AthleteEntity athleteEntity = athleteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pas d'athlète pour l'id " + id));
        athleteEntity.setFirstname(athleteBody.getFirstname());
        athleteEntity.setSurname(athleteBody.getSurname());
        athleteEntity.setAge(athleteBody.getAge());
        athleteEntity.setSport(athleteBody.getSport());
        athleteEntity.setCountry(athleteBody.getCountry());
        return Mapper.mapAtheAthleteEntityToAthleteDto(athleteRepository.saveAndFlush(athleteEntity));
    }

    @Override
    public void deleteAthlete(final Long id) {
        AthleteDto athleteById = getAthleteById(id);
        athleteRepository.deleteById(id);
    }
}
