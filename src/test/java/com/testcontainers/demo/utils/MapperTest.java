package com.testcontainers.demo.utils;

import com.testcontainers.demo.dto.AthleteBody;
import com.testcontainers.demo.dto.AthleteDto;
import com.testcontainers.demo.entity.AthleteEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapperTest {

    @Test
    void testMapAtheAthleteEntityToAthleteDto() {
        // Arrange
        AthleteEntity athleteEntity = new AthleteEntity(1, "Florian", "Lefeuvre", 40, "Paddle", "France");
        // Act
        AthleteDto athleteDto = Mapper.mapAtheAthleteEntityToAthleteDto(athleteEntity);

        // Assert
        Assertions.assertEquals(athleteEntity.getId(), athleteDto.getId());
        Assertions.assertEquals(athleteEntity.getSurname(), athleteDto.getSurname());
        Assertions.assertEquals(athleteEntity.getFirstname(), athleteDto.getFirstname());
        Assertions.assertEquals(athleteEntity.getAge(), athleteDto.getAge());
        Assertions.assertEquals(athleteEntity.getSport(), athleteDto.getSport());
        Assertions.assertEquals(athleteEntity.getCountry(), athleteDto.getCountry());
    }

    @Test
    void testMapAtheAthleteBodyToAthleteEntity() {
        // Arrange
        AthleteBody athleteBody = new AthleteBody("Florian", "Lefeuvre", 40, "Paddle", "France");

        // Act
        AthleteEntity athleteEntity = Mapper.mapAtheAthleteBodyToAthleteEntity(athleteBody);

        // Assert
        Assertions.assertEquals(athleteBody.getSurname(), athleteEntity.getSurname());
        Assertions.assertEquals(athleteBody.getFirstname(), athleteEntity.getFirstname());
        Assertions.assertEquals(athleteBody.getAge(), athleteEntity.getAge());
        Assertions.assertEquals(athleteBody.getSport(), athleteEntity.getSport());
        Assertions.assertEquals(athleteBody.getCountry(), athleteEntity.getCountry());
    }
}
