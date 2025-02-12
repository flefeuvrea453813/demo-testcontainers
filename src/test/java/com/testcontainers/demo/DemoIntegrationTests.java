package com.testcontainers.demo;

import com.testcontainers.demo.config.AbstractControllerTests;
import com.testcontainers.demo.dto.Address;
import com.testcontainers.demo.dto.AthleteBody;
import com.testcontainers.demo.entity.AthleteEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class DemoIntegrationTests extends AbstractControllerTests {

    @Test
    @DisplayName("Test de la récupération de tous les athletes en base")
    void testGetAll() throws Exception {
        this.mockMvc
                .perform(get("/athlete")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(7)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].age", equalTo(26)))
                .andExpect(jsonPath("$[0].firstname", equalTo("Camille")))
                .andExpect(jsonPath("$[0].surname", equalTo("Regneault")))
                .andExpect(jsonPath("$[0].country", equalTo("France")))
                .andExpect(jsonPath("$[0].sport", equalTo("Breaking")));
    }

    @Test
    @DisplayName("Test de la récupération de l'athlete ayant l'id 1")
    void testGetAthleteByExistingId() throws Exception {
        this.mockMvc
                .perform(get("/athlete/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.age", equalTo(26)))
                .andExpect(jsonPath("$.firstname", equalTo("Camille")))
                .andExpect(jsonPath("$.surname", equalTo("Regneault")))
                .andExpect(jsonPath("$.country", equalTo("France")))
                .andExpect(jsonPath("$.sport", equalTo("Breaking")));
    }

    @Test
    @DisplayName("Test de la récupération de l'athlete n'existant pas")
    void testGetAthleteByNotExistingId() throws Exception {
        this.mockMvc
                .perform(get("/athlete/11")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test de la récupération de l'athlete ayant le surname Defay")
    void testGetAthleteByExistingSurname() throws Exception {
        this.mockMvc
                .perform(get("/athlete/surname/Defay")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(4)))
                .andExpect(jsonPath("$[0].age", equalTo(30)))
                .andExpect(jsonPath("$[0].firstname", equalTo("Johanne")))
                .andExpect(jsonPath("$[0].surname", equalTo("Defay")))
                .andExpect(jsonPath("$[0].country", equalTo("France")))
                .andExpect(jsonPath("$[0].sport", equalTo("Surf")))
                .andExpect(jsonPath("$[0].address").isEmpty());
    }

    @Test
    @DisplayName("Test de la récupération de l'athlete n'existant pas")
    void testGetAthleteByNotExistingSurname() throws Exception {
        this.mockMvc
                .perform(get("/athlete/surname/Lefeuvre")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @DisplayName("Test de la récupération de l'athlete faisant de la /Natation Artistique")
    void testGetAthleteBySport() throws Exception {
        this.mockMvc
                .perform(get("/athlete/sport/Natation Artistique")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", equalTo(6)))
                .andExpect(jsonPath("$[0].age", equalTo(22)))
                .andExpect(jsonPath("$[0].firstname", equalTo("Maryna")))
                .andExpect(jsonPath("$[0].surname", equalTo("Aleksiïva")))
                .andExpect(jsonPath("$[0].country", equalTo("Ukraine")))
                .andExpect(jsonPath("$[0].sport", equalTo("Natation Artistique")))
                .andExpect(jsonPath("$[1].id", equalTo(7)))
                .andExpect(jsonPath("$[1].age", equalTo(22)))
                .andExpect(jsonPath("$[1].firstname", equalTo("Vladyslava")))
                .andExpect(jsonPath("$[1].surname", equalTo("Aleksiïva")))
                .andExpect(jsonPath("$[1].country", equalTo("Ukraine")))
                .andExpect(jsonPath("$[1].sport", equalTo("Natation Artistique")));
    }

    @Test
    @DisplayName("Test de la récupération de l'athlete n'existant pas")
    void testGetAthleteByNotExistingSport() throws Exception {
        this.mockMvc
                .perform(get("/athlete/sport/curling")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @DisplayName("Test mise à jour d'un athlete n'existant pas")
    void testUpdateAthleteNotExisting() throws Exception {
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteBody athleteBody = new AthleteBody("Florian", "Lefeuvre", 20, "Hobby Horse", "France", address);

        this.mockMvc
                .perform(put("/athlete/10")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(athleteBody)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test suppression d'un athlete n'existant pas")
    void testDeleteAthleteNotExisting() throws Exception {
        this.mockMvc
                .perform(delete("/athlete/10")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test CRUD")
    void testCreateAthlete() throws Exception {
        Address address = new Address(10, "intendance", "33000", "BORDEAUX");
        AthleteBody athleteBody = new AthleteBody("Florian", "Lefeuvre", 20, "Hobby Horse", "France", address);

        ResultActions resultActions = this.mockMvc
                .perform(post("/athlete")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(athleteBody)))
                .andExpect(status().isCreated());
        String uri = resultActions.andReturn().getResponse().getHeader("uri");

        address.setNumero(12);
        athleteBody = new AthleteBody("Florian", "Lefeuvre", 40, "Paddle", "France", address);
        this.mockMvc
                .perform(put(uri)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(athleteBody)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(8)))
                .andExpect(jsonPath("$.age", equalTo(40)))
                .andExpect(jsonPath("$.firstname", equalTo("Florian")))
                .andExpect(jsonPath("$.surname", equalTo("Lefeuvre")))
                .andExpect(jsonPath("$.country", equalTo("France")))
                .andExpect(jsonPath("$.sport", equalTo("Paddle")))
                .andExpect(jsonPath("$.address").exists())
                .andExpect(jsonPath("$.address.numero", equalTo(12)))
                .andExpect(jsonPath("$.address.rue", equalTo("intendance")))
                .andExpect(jsonPath("$.address.code_postal", equalTo("33000")))
                .andExpect(jsonPath("$.address.ville", equalTo("BORDEAUX")));

        this.mockMvc
                .perform(delete("/athlete/8")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
