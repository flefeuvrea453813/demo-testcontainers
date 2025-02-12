package com.testcontainers.demo.utils;

import com.testcontainers.demo.dto.Address;
import com.testcontainers.demo.dto.AthleteBody;
import com.testcontainers.demo.dto.AthleteDto;
import com.testcontainers.demo.entity.AthleteEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class MapperTest {

    @Test
    void testMapAtheAthleteEntityToAthleteDto() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteEntity athleteEntity = new AthleteEntity(1, "Florian", "Lefeuvre", 40, "Paddle", "France", address);
        // Act
        AthleteDto athleteDto = Mapper.mapAtheAthleteEntityToAthleteDto(athleteEntity);

        // Assert
        Assertions.assertEquals(athleteEntity.getId(), athleteDto.getId());
        Assertions.assertEquals(athleteEntity.getSurname(), athleteDto.getSurname());
        Assertions.assertEquals(athleteEntity.getFirstname(), athleteDto.getFirstname());
        Assertions.assertEquals(athleteEntity.getAge(), athleteDto.getAge());
        Assertions.assertEquals(athleteEntity.getSport(), athleteDto.getSport());
        Assertions.assertEquals(athleteEntity.getCountry(), athleteDto.getCountry());
        Assertions.assertNotNull(athleteDto.getAddress());
        Assertions.assertEquals(address.getNumero(), athleteDto.getAddress().getNumero());
        Assertions.assertEquals(address.getRue(), athleteDto.getAddress().getRue());
        Assertions.assertEquals(address.getCode_postal(), athleteDto.getAddress().getCode_postal());
        Assertions.assertEquals(address.getVille(), athleteDto.getAddress().getVille());
    }

    @Test
    void testMapAtheAthleteBodyToAthleteEntity() {
        // Arrange
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteBody athleteBody = new AthleteBody("Florian", "Lefeuvre", 40, "Paddle", "France", address);

        // Act
        AthleteEntity athleteEntity = Mapper.mapAtheAthleteBodyToAthleteEntity(athleteBody);

        // Assert
        Assertions.assertEquals(athleteBody.getSurname(), athleteEntity.getSurname());
        Assertions.assertEquals(athleteBody.getFirstname(), athleteEntity.getFirstname());
        Assertions.assertEquals(athleteBody.getAge(), athleteEntity.getAge());
        Assertions.assertEquals(athleteBody.getSport(), athleteEntity.getSport());
        Assertions.assertEquals(athleteBody.getCountry(), athleteEntity.getCountry());
        Assertions.assertNotNull(athleteEntity.getAddress());
        Assertions.assertEquals(athleteBody.getAddress().getNumero(), athleteEntity.getAddress().getNumero());
        Assertions.assertEquals(athleteBody.getAddress().getRue(), athleteEntity.getAddress().getRue());
        Assertions.assertEquals(athleteBody.getAddress().getCode_postal(), athleteEntity.getAddress().getCode_postal());
        Assertions.assertEquals(athleteBody.getAddress().getVille(), athleteEntity.getAddress().getVille());
    }
}
