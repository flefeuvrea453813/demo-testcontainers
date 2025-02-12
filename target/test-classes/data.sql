CREATE TABLE IF NOT EXISTS athlete
(
    id bigserial NOT NULL,
    firstname VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    age bigint NOT NULL,
    sport VARCHAR NOT NULL,
    country VARCHAR NOT NULL,
    adress JSONB,
    CONSTRAINT athlete_pkey  PRIMARY KEY (id)
);

INSERT INTO athlete(firstname, surname, age, sport, country, address) VALUES ('Camille', 'Regneault', 26, 'Breaking', 'France', NULL);
INSERT INTO athlete(firstname, surname, age, sport, country, address) VALUES ('Līna', 'Mūze', 31, 'Lancer de javelot', 'Lettonie', NULL);
INSERT INTO athlete(firstname, surname, age, sport, country, address) VALUES ('Matthew', 'Wearn', 28, 'Voile', 'Australie', NULL);
INSERT INTO athlete(firstname, surname, age, sport, country, address) VALUES ('Johanne', 'Defay', 30, 'Surf', 'France', NULL);
INSERT INTO athlete(firstname, surname, age, sport, country, address) VALUES ('Bassa', 'Mawem', 39, 'Escalade sportive', 'France', JSON '{"numero": 10,"rue": "intendance","code_postal": "33000","ville": "BORDEAUX"}');
INSERT INTO athlete(firstname, surname, age, sport, country, address) VALUES ('Maryna', 'Aleksiïva', 22, 'Natation Artistique', 'Ukraine', NULL);
INSERT INTO athlete(firstname, surname, age, sport, country, address) VALUES ('Vladyslava', 'Aleksiïva', 22, 'Natation Artistique', 'Ukraine', NULL);