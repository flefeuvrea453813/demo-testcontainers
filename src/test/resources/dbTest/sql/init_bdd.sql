CREATE SCHEMA if not exists demo;

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