--Oppgave 1
SELECT f.partid, c.partid, c.filmcharacter, p.firstname, p.lastname
FROM filmparticipation f, filmcharacter c, person p
WHERE f.partid = c.partid AND f.personid = p.personid AND f.filmid IN (808150, 6537994, 6538010);
        -- 108 rader

--Oppgave 2
SELECT count(f.country), c.country
FROM filmcountry f, country c
WHERE f.country = c.country
GROUP BY f.country, c.country
ORDER BY count(f.country) DESC;
        -- 190 rader

--Oppgave 3
SELECT avg(cast(time as int)), country
FROM runningtime
WHERE country IS NOT NULL AND time ~ '^\d+$'
GROUP BY country 
HAVING count(*) >= 200;
        -- 44 rader

-- Oppgave 4
SELECT count(g.filmid) AS genre, title
FROM filmgenre g, film f
WHERE g.filmid = f.filmid
GROUP BY title
ORDER BY genre DESC
LIMIT 10;
        -- 10 rader

-- Oppgave 5
SELECT c.country, count(*) AS movies, avg(cast(r.rank AS int)), max(g.genre) AS commongenre
FROM filmcountry as c
JOIN filmrating AS r USING(filmid)
JOIN filmgenre AS g USING(filmid)
GROUP BY country;
        -- 170 rader

-- Oppgave 6
SELECT person_en.filmid, person_en.lastname, 
       person_en.firstname, person_en.country, 
       person_to.filmid, person_to.lastname,
       person_to.firstname, person_to.country
FROM
    (
    SELECT fp.filmid, fp.personid, p.lastname, p.firstname, fc.country
    FROM filmparticipation fp 
    JOIN person p ON p.personid = fp.personid
    JOIN filmcountry fc ON fc.filmid = fp.filmid
    GROUP BY fp.filmid, fp.personid, p.lastname, p.firstname, fc.country
    HAVING count(fp.personid) > 40
    ) person_en

    INNER JOIN

    (
    SELECT fp.filmid, fp.personid, p.lastname, p.firstname, fc.country
    FROM filmparticipation fp 
    JOIN person p ON p.personid = fp.personid
    JOIN filmcountry fc ON fc.filmid = fp.filmid
    GROUP BY fp.filmid, fp.personid, p.lastname, p.firstname, fc.country
    HAVING count(fp.personid) > 40
    ) person_to
    ON person_en.filmid = person_to.filmid
WHERE person_en.personid < person_to.personid
ORDER BY person_en.filmid
LIMIT 10;
        -- 1 rad (usikker med denne oppg)

-- Oppgave 7
SELECT DISTINCT(film.filmid), film.title, film.prodyear 
FROM film 
RIGHT JOIN filmgenre ON filmgenre.filmid = film.filmid 
RIGHT JOIN filmcountry ON filmcountry.filmid = film.filmid 
WHERE (film.title LIKE '%Dark%' OR film.title LIKE '%Night%') 
AND (filmgenre.genre = 'Horror' or filmcountry.country = 'Romania');

        -- 445 rader

-- Oppgave 8
SELECT count(p.personid), p.filmid, f.prodyear
FROM filmparticipation p, film f
WHERE p.filmid = f.filmid
GROUP BY p.filmid, f.prodyear
HAVING count(p.personid) <= 2 AND f.prodyear >= 2010;
        -- 26 rader

-- Oppgave 9
SELECT count(filmid)
FROM filmgenre
WHERE NOT filmgenre.genre = 'Horror' AND NOT filmgenre.genre = 'Sci-Fi';
        -- 1 rad

-- Oppgave 10
SELECT f.title, count(l.language) AS languages
FROM
(SELECT f.title, max(r.rank) AS rank, max(r.votes) AS votes
FROM filmrating r, film f
WHERE r.filmid = f.filmid AND r.rank >= 8 AND r.votes > 1000
--GROUP BY f.title, rank, votes
ORDER BY votes DESC, rank DESC
LIMIT 10) AS highestRankVotes

UNION 

(SELECT f.title, max(r.rank) AS rank, max(r.votes) AS votes
FROM filmrating r, film f, filmparticipation p
WHERE r.filmid = f.filmid AND f.filmid = p.filmid AND r.rank >= 8 
AND r.votes > 1000 AND (p.personid = 926903 OR p.personid = 1501573) AS harrisonFordMovies
--GROUP BY f.title, r.rank, r.votes, p.personid
--GROUP BY votes DESC, rank DESC)

UNION

(SELECT g.genre, g.filmid, f.title, max(r.rank) AS rank, max(r.votes) AS votes
    FROM filmgenre g, film f, filmrating r
    WHERE r.rank >= 8 AND r.votes > 1000 AND (g.genre = 'Comedy' OR g.genre = 'Romance')
--GROUP BY f.title, r.rank, r.votes
ORDER BY votes DESC, rank DESC) AS comedyRomanceMovies

GROUP BY f.title, languages;