use Agenti;

SELECT *
FROM Beneficiar B INNER JOIN Cerere C ON B.CodB = C.CodB;

SELECT *
FROM Beneficiar B, Cerere C
WHERE B.CodB = C.CodB;

-- Numele furnizorilor din Cluj care ofera calculatoare
SELECT F.Nume, P.Nume
FROM Furnizor F JOIN Oferte O ON F.CodF = O.CodF
	JOIN Produs P ON O.CodP = P.CodP
WHERE P.Nume LIKE '%Calculator%';

-- 6.5.1
-- a
SELECT Nume
FROM Beneficiar
WHERE Oras = 'Bucuresti';

-- b
SELECT Nume
FROM Beneficiar
WHERE Oras != 'Bucuresti' AND Oras != 'Cluj';

SELECT Nume
FROM Beneficiar
WHERE Oras != 'Bucuresti'
INTERSECT
SELECT Nume
FROM Beneficiar
WHERE Oras != 'Cluj';

SELECT Nume
FROM Beneficiar
WHERE Oras NOT IN ('Bucuresti', 'Cluj');

-- c
SELECT P.Nume
FROM Produs P JOIN Tranzactii T 
	ON P.CodP = T.CodT;

-- d
-- Au cumparat calculatoare = au tranzactii incheiate pentru calculatoare
-- Un produs e calculator cand are in nume cuvantul 'Calculator'
-- SELECT: ce informatii trebuie returnate
-- FROM: tabelele din care luam informatii / tabelele prin care trebuie sa trecem ca sa luam informatia
--		coloanele prin care se leaga tabelele
-- WHERE: conditiile de filtrare ale rezultatelor
SELECT B.Nume
FROM Beneficiar B JOIN Tranzactii T ON B.CodB = T.CodB
	JOIN Produs P ON T.CodP = P.CodP
WHERE B.Oras = 'Bucuresti' AND P.Nume LIKE '%Calculator%';

-- e
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON P.CodP = C.CodP
WHERE P.Nume LIKE '%Calculator%';

-- f
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON P.CodP = C.CodP
WHERE P.Nume LIKE '%Calculator%'
INTERSECT
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON P.CodP = C.CodP
WHERE P.Nume LIKE '%Automobil%';

SELECT B.Nume
FROM Beneficiar B
WHERE B.CodB IN (
	-- Multimea de CodB a beneficiarilor ce au cereri pentru calculatoare
		SELECT C1.CodB
		FROM Cerere C1 JOIN Produs P1
			ON C1.CodP = P1.CodP
		WHERE P1.Nume LIKE '%Calculator%'
	)
	-- Multimea de CodB a beneficiarilor ce au cereri pentru automobile
	AND B.CodB IN (
		SELECT C2.CodB
		FROM Cerere C2 JOIN Produs P2
			ON C2.CodP = P2.CodP
		WHERE P2.Nume LIKE '%Automobil%'
	);

-- g
SELECT B.Nume
FROM Beneficiar B
WHERE B.CodB NOT IN (
	SELECT CodB FROM Cerere
);
-- Verificam daca B.CodB e in multimea codurilor B din tabela Cerere

-- h
-- Numele beneficiarilor care nu au cereri de calculatoare si nici de automobile
-- Select ce returneaza codb ai beneficiarilor ce au cereri de calculatoare
-- Select ce returneaza codb ai beneficiarilor ce au cereri de automobile
-- Sa verificam ca codb nu e in astea doua


SELECT B.Nume
FROM Beneficiar B
WHERE B.CodB NOT IN (
	-- Multimea de CodB a beneficiarilor ce au cereri pentru calculatoare
		SELECT C1.CodB
		FROM Cerere C1 JOIN Produs P1
			ON C1.CodP = P1.CodP
		WHERE P1.Nume LIKE '%Calculator%'
	)
	-- Multimea de CodB a beneficiarilor ce au cereri pentru automobile
	OR B.CodB NOT IN (
		SELECT C2.CodB
		FROM Cerere C2 JOIN Produs P2
			ON C2.CodP = P2.CodP
		WHERE P2.Nume LIKE '%Automobil%'
	);

-- i
SELECT B.Nume, COUNT(DISTINCT T.CodP)
FROM Beneficiar B JOIN Tranzactii T 
	ON B.CodB = T.CodB
GROUP BY B.Nume
HAVING COUNT(DISTINCT T.CodP) >= 2;