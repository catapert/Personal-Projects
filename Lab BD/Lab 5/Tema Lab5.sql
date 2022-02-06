--Tema Lab5
use Agenti

--Exercitiul 6.5.1
--a)
SELECT B.Nume
FROM Beneficiar B
WHERE B.Oras='Bucuresti';

--b)
SELECT B.Nume
FROM Beneficiar B
WHERE B.Oras !='Bucuresti' AND B.Oras !='Cluj';

--c)
SELECT P.Nume
FROM Produs P JOIN Tranzactii T ON P.CodP=T.CodP;

--d)
SELECT B.Nume
FROM Beneficiar B JOIN Tranzactii T ON B.CodB = T.CodB
	JOIN Produs P ON T.CodP = P.CodP
WHERE B.Oras = 'Bucuresti' AND P.Nume LIKE '%Calculator%';

--e)
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON C.CodP = P.CodP
WHERE P.Nume LIKE '%Calculator&';

--f)
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON C.CodP = P.CodP
WHERE P.Nume LIKE '%Calculator&' AND B.CodB IN (
	SELECT C1.CodB
	FROM Cerere C1 JOIN Produs P1 ON C1.CodP = P1.CodP
	WHERE P1.Nume LIKE '%Automobil%'
);

--g)
SELECT B.Nume
FROM Beneficiar B
WHERE B.CodB NOT IN (
	SELECT CodB
	FROM Cerere
	);

--h)
SELECT B.Nume
FROM Beneficiar B
WHERE B.CodB NOT IN (
	SELECT C.CodB
	FROM Cerere C JOIN Produs P ON C.CodP = P.CodP
	WHERE P.Nume = '%Calculator%'
	)
	AND
	B.CodB NOT IN (
	SELECT C.CodB
	FROM Cerere C JOIN Produs P ON C.CodP = P.CodP
	WHERE P.Nume = '%Automobil%'
	);

--i)
SELECT B.Nume, COUNT(DISTINCT C.CodP)
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
GROUP BY B.Nume
HAVING COUNT(DISTINCT C.CodP) >= 2;

--j)
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
GROUP BY B.Nume
HAVING COUNT(DISTINCT C.CodP) IN (
	SELECT COUNT(DISTINCT P.CodP)
	FROM Produs P
)

--k)
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB=C.CodB 
		JOIN Produs P ON P.CodP=C.CodP
WHERE P.Nume LIKE '%Calculator%' OR P.Nume LIKE '%Automobil%'
GROUP BY B.Nume
HAVING COUNT(DISTINCT C.CodP) IN (
	SELECT COUNT(DISTINCT P1.CodP)
	FROM Produs P1
	WHERE P1.Nume LIKE '%Calculator%' OR P1.Nume LIKE '%Automobil%'
)

--l)
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
GROUP BY B.Nume
HAVING COUNT(DISTINCT C.CodP) NOT IN (
	SELECT COUNT(DISTINCT P.CodP)
	FROM Produs P
)

--m)
SELECT B.Nume, COUNT(DISTINCT C.CodP)
FROM Beneficiar B JOIN Cerere C ON B.CodB=C.CodB
GROUP BY B.Nume
INTERSECT
SELECT B1.Nume, COUNT(DISTINCT T.CodP)
FROM Beneficiar B1 JOIN Tranzactii T ON B1.CodB=T.CodB
GROUP BY B1.Nume

--Exercitiul 6.5.2
--a)
(SELECT F.Nume 
FROM Furnizor F JOIN Tranzactii T ON F.CodF = T.CodF
	JOIN Beneficiar B ON T.CodB = B.CodB
WHERE B.Oras LIKE 'Bucuresti')
INTERSECT
(SELECT F.Nume 
FROM Furnizor F JOIN Tranzactii T ON F.CodF = T.CodF
	JOIN Beneficiar B ON T.CodB = B.CodB
WHERE B.Oras LIKE 'Cluj')

--b)
(SELECT F.Nume 
FROM Furnizor F JOIN Tranzactii T ON F.CodF = T.CodF
	JOIN Beneficiar B ON T.CodB = B.CodB
WHERE B.Oras LIKE 'Bucuresti')
EXCEPT
(SELECT F.Nume 
FROM Furnizor F JOIN Tranzactii T ON F.CodF = T.CodF
	JOIN Beneficiar B ON T.CodB = B.CodB
WHERE B.Oras LIKE 'Cluj')

--c)
SELECT Nume
FROM Furnizor F
WHERE NOT EXISTS
	((SELECT CodP
	FROM Produs)
	EXCEPT
	(SELECT CodP
	FROM Oferte
	WHERE F.CodF=CodF));






