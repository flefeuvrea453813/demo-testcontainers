CREATE TABLE IF NOT EXISTS athlete
(
    id bigserial NOT NULL,
    firstname VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    age bigint NOT NULL,
    sport VARCHAR NOT NULL,
    country VARCHAR NOT NULL,
    CONSTRAINT athlete_pkey  PRIMARY KEY (id)
);

INSERT INTO athlete(firstname, surname, age, sport, country) VALUES ('Camille', 'Regneault', 26, 'Breaking', 'France');
INSERT INTO athlete(firstname, surname, age, sport, country) VALUES ('Līna', 'Mūze', 31, 'Lancer de javelot', 'Lettonie');
INSERT INTO athlete(firstname, surname, age, sport, country) VALUES ('Matthew', 'Wearn', 28, 'Voile', 'Australie');
INSERT INTO athlete(firstname, surname, age, sport, country) VALUES ('Johanne', 'Defay', 30, 'Surf', 'France');
INSERT INTO athlete(firstname, surname, age, sport, country) VALUES ('Bassa', 'Mawem', 39, 'Escalade sportive', 'France');
INSERT INTO athlete(firstname, surname, age, sport, country) VALUES ('Maryna', 'Aleksiïva', 22, 'Natation Artistique', 'Ukraine');
INSERT INTO athlete(firstname, surname, age, sport, country) VALUES ('Vladyslava', 'Aleksiïva', 22, 'Natation Artistique', 'Ukraine');