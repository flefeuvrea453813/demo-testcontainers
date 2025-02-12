ALTER TABLE athlete ADD COLUMN address jsonb DEFAULT '{}'::jsonb;

UPDATE athlete SET address = '{"numero": 10,"rue": "intendance","code_postal":"33000", "ville":"BORDEAUX"}'::jsonb WHERE firstname = 'Camille' ;