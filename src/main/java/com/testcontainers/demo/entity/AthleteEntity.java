package com.testcontainers.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "athlete")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private long id;

    @Column
    private String firstname;

    @Column
    private String surname;

    @Column
    private int age;

    @Column
    private String sport;

    @Column
    private String country;
}
