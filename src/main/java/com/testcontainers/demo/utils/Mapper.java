package com.testcontainers.demo.utils;

import com.testcontainers.demo.dto.AthleteBody;
import com.testcontainers.demo.dto.AthleteDto;
import com.testcontainers.demo.entity.AthleteEntity;

public class Mapper {

    public static AthleteDto mapAtheAthleteEntityToAthleteDto(AthleteEntity athleteEntity) {
        return new AthleteDto(athleteEntity.getId(), athleteEntity.getFirstname(), athleteEntity.getSurname(), athleteEntity.getAge(), athleteEntity.getSport(), athleteEntity.getCountry());
    }

    public static AthleteEntity mapAtheAthleteBodyToAthleteEntity(AthleteBody athleteBody) {
        AthleteEntity athleteEntity = new AthleteEntity();
        athleteEntity.setFirstname(athleteBody.getFirstname());
        athleteEntity.setSurname(athleteBody.getSurname());
        athleteEntity.setAge(athleteBody.getAge());
        athleteEntity.setSport(athleteBody.getSport());
        athleteEntity.setCountry(athleteBody.getCountry());
        return  athleteEntity;
    }
}
