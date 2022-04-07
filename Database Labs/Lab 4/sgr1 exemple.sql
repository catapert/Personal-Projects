use Agenti;

-- SELECT
-- ALL/DISTINCT
SELECT DISTINCT Nume
FROM Angajati;

SELECT Nume + ' ' + Prenume
FROM Angajati;

-- TOP
SELECT TOP 5 Nume
FROM Angajati;

SELECT TOP 25 PERCENT Nume
FROM Angajati;

-- INTO
SELECT Nume INTO Tabela_Nume_De_Familie
FROM Angajati;

-- FROM
SELECT B.Oras
FROM Birouri AS B;

SELECT GETDATE();

-- WHERE
-- Selecteaza angajatii care au varsta peste 20 de ani
SELECT A.Nume, A.Prenume, A.Varsta
FROM Angajati A
WHERE A.Varsta > 20;

-- Numele angajatilor ai caror nume incepe cu litera P sau C
SELECT A.Nume
FROM Angajati A
WHERE A.Nume LIKE 'P%' OR A.Nume LIKE 'C%';

-- Numele angajatilor care nu au un birou asignat
SELECT A.Nume
FROM Angajati A
WHERE A.Id_birou IS NULL;

-- GROUP BY
-- Media salariilor pentru angajatii cu acelasi nume de familie
SELECT A.Nume, AVG(A.Salariu)
FROM Angajati A
GROUP BY A.Nume;

-- Suma varstei pentru angajatii cu acelasi nume // SUM
SELECT A.Nume, SUM(A.Varsta)
FROM Angajati A
GROUP BY A.Nume;

-- Media varstei pentru angajatii cu acelasi prenume, pentru prenumele care incep cu litera A
SELECT A.Prenume, AVG(A.Varsta)
FROM Angajati A
WHERE A.Prenume LIKE 'A%'
GROUP BY A.Prenume;

-- HAVING
-- Grupurile de nume de angajati care au media varstei peste 20 de ani
SELECT A.Nume, AVG(A.Varsta) AS Medie_Varsta
FROM Angajati A
GROUP BY A.Nume
HAVING AVG(A.Varsta) >= 20;

-- Grupurile de prenume de angajati care au suma salariilor peste 2000
SELECT A.Prenume, SUM(A.Salariu)
FROM Angajati A
GROUP BY A.Prenume
HAVING SUM(A.Salariu) >= 2000 AND A.Prenume LIKE 'A%';


-- UNION / INTERSECT / MINUS
-- Angajatii ai caror nume incepe cu P sau C
SELECT A.Nume
FROM Angajati A
WHERE A.Nume LIKE 'P%' OR A.Nume LIKE 'C%';

-- UNION
SELECT A.Nume, A.Prenume
FROM Angajati A
WHERE A.Nume LIKE 'P%'
UNION ALL   -- ALL - include si duplicate
SELECT A.Nume, A.Prenume
FROM Angajati A
WHERE A.Nume LIKE 'C%';

-- UNION -- face reuniunuea dintre doua relatii rezultat
-- INTERSECT -- face intersectia dintre doua relatii rezultat
-- MINUS -- face diferenta dintre doua relatii rezultat

-- ORDER BY
-- Numele angajatilor din tabela angajati ordonate alfabetic
SELECT A.Nume, A.Prenume
FROM Angajati A
ORDER BY A.Nume ASC, A.Prenume DESC;

-- Ordonam grupurile de nume dupa media de varsta
SELECT A.Nume, AVG(A.Varsta)
FROM Angajati A
GROUP BY A.Nume
ORDER BY AVG(A.Varsta) DESC;

-- FUNCTII DE AGREGARE
SELECT COUNT(*)
FROM Angajati;

SELECT COUNT(ALL Id_birou)
FROM Angajati;

SELECT COUNT(DISTINCT Nume)
FROM Angajati;

-- Numarul de anagajati cu acelasi nume de familie
SELECT A.Nume, Count(*)
FROM Angajati A
GROUP BY A.Nume;

-- TIPURI DE CUPLARE - JOIN-URI
SELECT *
FROM Angajati A INNER JOIN Birouri B ON A.Id_birou = B.Id_b;

-- Numele si prenumele fiecarui angajat alaturi de orasul in care e biroul sau
SELECT A.Nume, A.Prenume, B.Oras
FROM Angajati A JOIN Birouri B ON A.Id_birou = B.Id_b;

-- CROSS JOIN
SELECT *
FROM Angajati CROSS JOIN Birouri;

-- CROSS JOIN
SELECT *
FROM Angajati, Birouri;

-- INNER JOIN
SELECT *
FROM Angajati A,  Birouri B
WHERE A.Id_birou = B.Id_b;

-- SELECT IN SELECT
SELECT *
FROM (SELECT Nume FROM Angajati) Ang;

