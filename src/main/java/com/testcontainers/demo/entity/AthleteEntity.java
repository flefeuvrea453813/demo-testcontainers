package com.testcontainers.demo.entity;

import com.testcontainers.demo.dto.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

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

    @Type(JsonType.class)
    @Column(name = "address", columnDefinition = "jsonb")
    private Address address;
}
