package com.testcontainers.demo.service;

import com.testcontainers.demo.dto.Address;
import com.testcontainers.demo.dto.AthleteBody;
import com.testcontainers.demo.dto.AthleteDto;
import com.testcontainers.demo.entity.AthleteEntity;
import com.testcontainers.demo.exception.ResourceNotFoundException;
import com.testcontainers.demo.repository.AthleteRepository;
import com.testcontainers.demo.service.impl.AthleteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringJUnitConfig(classes = AthleteServiceImpl.class)
public class AthleteServiceImplTest {

    @Autowired
    private AthleteServiceImpl athleteService;

    @MockitoBean
    private AthleteRepository athleteRepository;

    @Test
    @DisplayName("Test getAllAthletes OK")
    void testGetAllAthletesOk() {
        // Arrange
        Mockito.when(athleteRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<AthleteDto> athletes = athleteService.getAllAthletes();

        // Assert
        Mockito.verify(athleteRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(0, athletes.size());
    }

    @Test
    @DisplayName("Test get athlete by id KO")
    void testGetAthleteByIdKo() {
        // Arrange
        Mockito.when(athleteRepository.findById(20L)).thenThrow(new ResourceNotFoundException("Pas d'athlète pour l'id 20"));

        // Act && Assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> athleteService.getAthleteById(20L));
    }

    @Test
    @DisplayName("Test get athlete by id OK")
    void testGetAthleteByIdOk() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteEntity athleteEntity = new AthleteEntity(1, "Florian", "Lefeuvre", 40, "Paddle", "France", address);
        Mockito.when(athleteRepository.findById(1L)).thenReturn(Optional.of(athleteEntity));

        // Act && Assert
        AthleteDto athleteDto = Assertions.assertDoesNotThrow(() -> athleteService.getAthleteById(1L));
        Mockito.verify(athleteRepository, Mockito.times(1)).findById(Mockito.eq(1L));
        Assertions.assertNotNull(athleteDto);
        Assertions.assertEquals(athleteEntity.getId(), athleteDto.getId());
        Assertions.assertEquals(athleteEntity.getFirstname(), athleteDto.getFirstname());
        Assertions.assertEquals(athleteEntity.getSurname(), athleteDto.getSurname());
        Assertions.assertEquals(athleteEntity.getAge(), athleteDto.getAge());
        Assertions.assertEquals(athleteEntity.getSport(), athleteDto.getSport());
        Assertions.assertEquals(athleteEntity.getCountry(), athleteDto.getCountry());
    }

    @Test
    @DisplayName("Test get athlete by surname")
    void testGetAthleteBySurnameOk() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteEntity athleteEntity = new AthleteEntity(1, "Florian", "Lefeuvre", 40, "Paddle", "France", address);
        Mockito.when(athleteRepository.findAllBySurname("Lefeuvre")).thenReturn(Arrays.asList(athleteEntity));

        // Act && Assert
        List<AthleteDto> athleteDtos = Assertions.assertDoesNotThrow(() -> athleteService.getAthletesBySurname("Lefeuvre"));
        Mockito.verify(athleteRepository, Mockito.times(1)).findAllBySurname(Mockito.eq("Lefeuvre"));
        Assertions.assertEquals(1, athleteDtos.size());
        Assertions.assertEquals(athleteEntity.getId(), athleteDtos.get(0).getId());
        Assertions.assertEquals(athleteEntity.getFirstname(), athleteDtos.get(0).getFirstname());
        Assertions.assertEquals(athleteEntity.getSurname(), athleteDtos.get(0).getSurname());
        Assertions.assertEquals(athleteEntity.getAge(), athleteDtos.get(0).getAge());
        Assertions.assertEquals(athleteEntity.getSport(), athleteDtos.get(0).getSport());
        Assertions.assertEquals(athleteEntity.getCountry(), athleteDtos.get(0).getCountry());
    }

    @Test
    @DisplayName("Test get athlete by country")
    void testGetAthleteByCountryOk() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteEntity athleteEntity = new AthleteEntity(1, "Florian", "Lefeuvre", 40, "Paddle", "France", address);
        Mockito.when(athleteRepository.findAllByCountry("France")).thenReturn(Arrays.asList(athleteEntity));

        // Act && Assert
        List<AthleteDto> athleteDtos = Assertions.assertDoesNotThrow(() -> athleteService.getAthletesByCountry("France"));
        Mockito.verify(athleteRepository, Mockito.times(1)).findAllByCountry(Mockito.eq("France"));
        Assertions.assertEquals(1, athleteDtos.size());
        Assertions.assertEquals(athleteEntity.getId(), athleteDtos.get(0).getId());
        Assertions.assertEquals(athleteEntity.getFirstname(), athleteDtos.get(0).getFirstname());
        Assertions.assertEquals(athleteEntity.getSurname(), athleteDtos.get(0).getSurname());
        Assertions.assertEquals(athleteEntity.getAge(), athleteDtos.get(0).getAge());
        Assertions.assertEquals(athleteEntity.getSport(), athleteDtos.get(0).getSport());
        Assertions.assertEquals(athleteEntity.getCountry(), athleteDtos.get(0).getCountry());
    }

    @Test
    @DisplayName("Test get athlete by sport")
    void testGetAthleteBySportOk() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteEntity athleteEntity = new AthleteEntity(1, "Florian", "Lefeuvre", 40, "Paddle", "France", address);
        Mockito.when(athleteRepository.findAllBySport("Paddle")).thenReturn(Arrays.asList(athleteEntity));

        // Act && Assert
        List<AthleteDto> athleteDtos = Assertions.assertDoesNotThrow(() -> athleteService.getAthletesBySport("Paddle"));
        Mockito.verify(athleteRepository, Mockito.times(1)).findAllBySport(Mockito.eq("Paddle"));
        Assertions.assertEquals(1, athleteDtos.size());
        Assertions.assertEquals(athleteEntity.getId(), athleteDtos.get(0).getId());
        Assertions.assertEquals(athleteEntity.getFirstname(), athleteDtos.get(0).getFirstname());
        Assertions.assertEquals(athleteEntity.getSurname(), athleteDtos.get(0).getSurname());
        Assertions.assertEquals(athleteEntity.getAge(), athleteDtos.get(0).getAge());
        Assertions.assertEquals(athleteEntity.getSport(), athleteDtos.get(0).getSport());
        Assertions.assertEquals(athleteEntity.getCountry(), athleteDtos.get(0).getCountry());
    }

    @Test
    @DisplayName("Test create athlete")
    void testCreateAthlete() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteBody athleteBody = new AthleteBody("Florian", "Lefeuvre", 40, "Paddle", "France", address);
        AthleteEntity athleteEntity = new AthleteEntity(1, athleteBody.getFirstname(), athleteBody.getSurname(), athleteBody.getAge(), athleteBody.getSport(), athleteBody.getCountry(), athleteBody.getAddress());
        Mockito.when(athleteRepository.saveAndFlush(Mockito.any(AthleteEntity.class))).thenReturn(athleteEntity);

        // Act && Assert
        AthleteDto athleteDto = athleteService.createAthlete(athleteBody);
        Mockito.verify(athleteRepository, Mockito.times(1)).saveAndFlush(Mockito.any(AthleteEntity.class));
        Assertions.assertEquals(1, athleteDto.getId());
        Assertions.assertEquals(athleteBody.getFirstname(), athleteDto.getFirstname());
        Assertions.assertEquals(athleteBody.getSurname(), athleteDto.getSurname());
        Assertions.assertEquals(athleteBody.getAge(), athleteDto.getAge());
        Assertions.assertEquals(athleteBody.getSport(), athleteDto.getSport());
        Assertions.assertEquals(athleteBody.getCountry(), athleteDto.getCountry());
    }

    @Test
    @DisplayName("Test delete inexistaing athlete")
    void testDeleteAthleteKo() {
        // Arrange
        Mockito.when(athleteRepository.findById(12L)).thenThrow(new ResourceNotFoundException(""));

        // Act && Assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> athleteService.deleteAthlete(12L));
    }

    @Test
    @DisplayName("Test delete existaing athlete")
    void testDeleteAthleteOk() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteEntity athleteEntity = new AthleteEntity(1, "Florian", "Lefeuvre", 40, "Paddle", "France", address);
        Mockito.when(athleteRepository.findById(1L)).thenReturn(Optional.of(athleteEntity));

        // Act && Assert
        Assertions.assertDoesNotThrow(() -> athleteService.deleteAthlete(1L));
        Mockito.verify(athleteRepository, Mockito.times(1)).findById(Mockito.eq(1L));
        Mockito.verify(athleteRepository, Mockito.times(1)).deleteById(Mockito.eq(1L));
    }

    @Test
    @DisplayName("Test update inexistaing athlete")
    void testUpdateAthleteKo() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteBody athleteBody = new AthleteBody("Florian", "Lefeuvre", 40, "Paddle", "France", address);
        Mockito.when(athleteRepository.findById(12L)).thenThrow(new ResourceNotFoundException(""));

        // Act && Assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> athleteService.updateAthlete(12L, athleteBody));
    }

    @Test
    @DisplayName("Test update existaing athlete")
    void testUpdateteAthleteOk() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteEntity athleteEntity = new AthleteEntity(1, "Florian", "Lefeuvre", 40, "Paddle", "France", address);
        AthleteBody athleteBody = new AthleteBody("Florian", "Lefeuvre", 40, "Tennis", "France", address);
        AthleteEntity athleteEntityUpdated = new AthleteEntity(1,  athleteBody.getFirstname(),  athleteBody.getSurname(),  athleteBody.getAge(),  athleteBody.getSport(), athleteBody.getCountry(), athleteBody.getAddress());
        Mockito.when(athleteRepository.findById(1L)).thenReturn(Optional.of(athleteEntity));
        Mockito.when(athleteRepository.saveAndFlush(Mockito.any(AthleteEntity.class))).thenReturn(athleteEntity);

        // Act && Assert
        Assertions.assertDoesNotThrow(() -> athleteService.updateAthlete(1L, athleteBody));
        Mockito.verify(athleteRepository, Mockito.times(1)).findById(Mockito.eq(1L));
        Mockito.verify(athleteRepository, Mockito.times(1)).saveAndFlush(Mockito.any(AthleteEntity.class));
    }



}
