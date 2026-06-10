-- Programmi predefiniti
INSERT INTO PROGRAMMI_REST (nome, kcal) VALUES ('Full Body', 350);
INSERT INTO PROGRAMMI_REST (nome, kcal) VALUES ('Push/Pull/Legs', 400);
INSERT INTO PROGRAMMI_REST (nome, kcal) VALUES ('Cardio', 500);
INSERT INTO PROGRAMMI_REST (nome, kcal) VALUES ('Strength', 300);

-- Esercizi Full Body (idProgramma = 1)
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (1, 'Squat', 4, 12, 80);
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (1, 'Panca Piana', 3, 10, 70);
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (1, 'Stacchi', 3, 8, 100);

-- Esercizi Push/Pull/Legs (idProgramma = 2)
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (2, 'Shoulder Press', 4, 10, 60);
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (2, 'Lat Machine', 4, 12, 70);
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (2, 'Leg Press', 4, 15, 90);

-- Esercizi Cardio (idProgramma = 3)
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (3, 'Corsa', 1, 30, 250);
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (3, 'Corda', 3, 50, 150);
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (3, 'Cyclette', 1, 20, 200);

-- Esercizi Strength (idProgramma = 4)
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (4, 'Deadlift', 5, 5, 120);
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (4, 'Overhead Press', 5, 5, 80);
INSERT INTO ESERCIZI (idProgramma, nomeEs, numSerie, numRep, kcal) VALUES (4, 'Trazioni', 4, 6, 60);