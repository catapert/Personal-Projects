use Agenti;

-- SELECT
SELECT DISTINCT Oras
FROM Birouri;

SELECT TOP 2 Oras
FROM Birouri;

-- INTO
SELECT DISTINCT Oras INTO Tabela_Orase
FROM Birouri

-- FROM
SELECT A.Nume, A.Varsta
FROM Angajati AS A;

-- WHERE
-- Angajatii ai caror nume incepe cu litera P
SELECT A.Nume
FROM Angajati A
WHERE A.Nume LIKE 'P%';

-- Angajatii care au sub 30 de ani
SELECT A.Nume
FROM Angajati A
WHERE A.Varsta < 30;

-- Angajatii care nu sunt parte dintr-un birou
SELECT A.Nume, A.Prenume
FROM Angajati A
WHERE A.Id_birou IS NULL;

-- GROUP BY
-- Media salariului angajatilor in functie de numele de familie
SELECT A.Nume, AVG(A.Salariu)
FROM Angajati A
GROUP BY A.Nume;

-- Suma varstei angajatilor cu acelasi nume si prenume
SELECT A.Nume, A.Prenume, SUM(A.Varsta)
FROM Angajati A
GROUP BY A.Nume, A.Prenume;

-- HAVING
-- Grupurile de nume care au media varstei peste 20
SELECT A.Nume, AVG(A.Varsta)
FROM Angajati A
GROUP BY A.Nume
HAVING AVG(A.Varsta) > 20;

-- Angajatii care au salariu peste 3000
SELECT A.Nume, A.Salariu
FROM Angajati A
WHERE A.Salariu > 3000;

-- Grupurile de nume de angajati care au media salariului peste 3000
SELECT A.Nume, AVG(A.Salariu)
FROM Angajati A
GROUP BY A.Nume
HAVING AVG(A.Salariu) > 3000;

-- UNION / INTERSECT / MINUS
-- Angajati ai caror nume incepe cu P sau cu C
SELECT A.Nume, A.Prenume
FROM Angajati A
WHERE A.Nume LIKE 'P%'
INTERSECT				-- ALL - include si duplicatele
SELECT A.Nume, A.Prenume
FROM Angajati A
WHERE A.Prenume LIKE 'C%';
-- UNION face reuniunea intre doua seturi
-- INTERSECT face intersectia dintre doua seturi
-- MINUS face operatia de scadere dintre doua seturi

-- ORDER BY
-- Ordonarea angajatilor dupa nume si prenume
SELECT A.Nume, A.Prenume
FROM Angajati A
ORDER BY A.Nume DESC, A.Prenume DESC; 

-- Media de varsta a grupurilor de nume si ordonarea ascendenta in functie de medie
SELECT A.Nume, AVG(A.Varsta)
FROM Angajati A
GROUP BY A.Nume
ORDER BY AVG(A.Varsta);

-- COUNT
SELECT COUNT(DISTINCT Nume)
FROM Angajati;

-- TIPURI DE CUPLARE - JOINURI
SELECT *
FROM Angajati A JOIN Birouri B ON A.Id_birou = B.Id_b;

-- Sa se selecteze toti angajatii si orasele in care sunt birourile lor
SELECT A.Nume, A.Prenume, B.Oras
FROM Angajati A INNER JOIN Birouri B ON A.Id_birou = B.Id_b;

-- ECHIVALENT CU INNER JOIN
SELECT A.Nume, A.Prenume, B.Oras
FROM Angajati A, Birouri B
WHERE A.Id_birou = B.Id_b;

-- CROSS JOIN
SELECT *
FROM Angajati CROSS JOIN Birouri;

-- TOT CROSS JOIN
SELECT *
FROM Angajati, Birouri;
