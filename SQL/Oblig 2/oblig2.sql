--Oppgave 2a
SELECT navn FROM planet 
WHERE stjerne = 'Proxima Centauri';
--Oppgave 2b
SELECT DISTINCT oppdaget FROM planet 
WHERE stjerne = 'TRAPPIST-1' OR stjerne = 'Kepler-154';
--Oppgave 2c
SELECT count(*) FROM planet 
WHERE masse IS NULL;
--Oppgave 2d
SELECT navn, masse FROM planet 
WHERE oppdaget = 2020 AND masse > (SELECT avg(masse) FROM planet);
--Oppgave 2e
SELECT (max(oppdaget) - min(oppdaget)) FROM planet;

--Oppgave 3a
SELECT navn FROM planet AS p 
INNER JOIN materie AS m ON(p.navn = m.planet) WHERE masse > 3 AND masse < 10 AND molekyl = 'H2O';
--Oppgave 3b
SELECT p.navn FROM planet AS p 
INNER JOIN stjerne AS s ON (p.stjerne = s.navn) 
INNER JOIN materie AS m ON(p.navn = m.planet)
WHERE avstand < s.masse*12 AND molekyl LIKE '%H%';
--Oppgave 3c
SELECT p1.navn FROM planet AS p1, planet AS p2, stjerne WHERE p1.stjerne = p2.stjerne AND p1.masse > 10 AND p2.masse > 10 AND avstand < 50;

--Oppgave 4
/*Nils får ikke det han leter etter, fordi natural join mellom planet og stjerne kombinerer samme attributter. I dette
tilfellet vil det være "navn", og alle navnene er unike. Derfor dukker det ikke opp noen rader.*/

--Oppgave 5a
INSERT INTO stjerne VALUES('Sola', 0, 1);
--Oppgave 5b
INSERT INTO planet VALUES('Jorda', 0.003146, NULL, 'Sola');

--Oppgave 6
CREATE TABLE observasjon(observasjons_id int PRIMARY KEY, tidspunkt TIMESTAMP, planet TEXT REFERENCES planet(navn), kommentar TEXT);