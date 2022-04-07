use Agenti;

SELECT *
FROM Furnizor F, Oferte O
WHERE F.CodF = O.CodF;


SELECT *
FROM Furnizor F INNER JOIN Oferte O ON F.CodF = O.CodF;

-- Numele furnizorilor din Cluj care ofera calculatoare
SELECT F.Nume
FROM Furnizor F JOIN Oferte O ON F.CodF = O.CodF
	JOIN Produs P ON O.CodP = P.CodP
WHERE P.Nume LIKE '%Calculator%';

-- 6.5.1
-- a
SELECT B.Nume
FROM Beneficiar B
WHERE B.Oras = 'Bucuresti';

-- b
SELECT B.Nume
FROM Beneficiar B
WHERE B.Oras != 'Bucuresti' AND B.Oras != 'Cluj' ;

SELECT B.Nume
FROM Beneficiar B
WHERE B.Oras NOT IN ('Bucuresti', 'Cluj');

SELECT B.Nume
FROM Beneficiar B
WHERE B.Oras != 'Bucuresti'
INTERSECT
SELECT B.Nume
FROM Beneficiar B
WHERE B.Oras != 'Cluj';

-- c
SELECT P.Nume
FROM Produs P JOIN Tranzactii T ON P.CodP = T.CodP;

SELECT P.Nume
FROM Produs P
WHERE P.CodP IN (
	SELECT T.CodP
	FROM Tranzactii T
);

-- d
-- Numele beneficiarilor din Bucuresti care au cumparat calculatoare
-- Au cumparat = au tranzactii facute cu calculatoare
-- Un produs e calculator cand numele lui contine cuvantul 'Calculator'
SELECT B.Nume
FROM Beneficiar B JOIN Tranzactii T ON B.CodB = T.CodB
	JOIN Produs P ON T.CodP = P.CodP
WHERE B.Oras = 'Bucuresti' AND P.Nume LIKE '%Calculator%';

-- e
-- Trebuie afisat: B.Nume
-- Ce tabele folosim: Beneficiar, Cerere, Produs
-- Legaturile se fac prin: CodB, CodP
-- Conditii: produsul sa fie calculator
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON C.CodP = P.CodP
WHERE P.Nume LIKE '%Calculator%';

-- f
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON C.CodP = P.CodP
WHERE P.Nume LIKE '%Calculator%' AND B.CodB IN (
	SELECT C1.CodB
	FROM Cerere C1 JOIN Produs P1 ON C1.CodP = P1.CodP
	WHERE P1.Nume LIKE '%Automobil%'
);

-- g
SELECT B.Nume
FROM Beneficiar B
WHERE CodB NOT IN (
	SELECT CodB
	FROM Cerere
);

-- h
-- CodB NOT IN ... AND CodB NOT IN ...
-- Lista codurilor beneficiarilor ce au cereri de calculatoare
-- Lista codurilor beneficiarilor ce au cereri de automobile
SELECT B.Nume
FROM Beneficiar B
WHERE B.CodB NOT IN (
		SELECT C1.CodB
		FROM Cerere C1 JOIN Produs P1 ON C1.CodP = P1.CodP
		WHERE P1.Nume LIKE '%Calculator%'
	)
	AND B.CodB NOT IN (
		SELECT C2.CodB
		FROM Cerere C2 JOIN Produs P2 ON C2.CodP = P2.CodP
		WHERE P2.Nume LIKE '%Automobil%'
	);

-- i
SELECT B.Nume, COUNT(DISTINCT C.CodP)
FROM Beneficiar B JOIN Cerere C
	ON B.CodB = C.CodB
GROUP BY B.Nume
HAVING COUNT(DISTINCT C.CodP) >= 2;






