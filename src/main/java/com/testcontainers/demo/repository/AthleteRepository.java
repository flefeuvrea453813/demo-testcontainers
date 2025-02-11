package com.testcontainers.demo.repository;

import com.testcontainers.demo.entity.AthleteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository  extends JpaRepository<AthleteEntity, Long> {
    List<AthleteEntity> findAllBySurname(String surname);

    List<AthleteEntity> findAllBySport(String sport);

    List<AthleteEntity> findAllByCountry(String country);
}
