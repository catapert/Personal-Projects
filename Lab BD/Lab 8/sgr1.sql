use Agenti;

-- CASE SIMPLU
/*
DECLARE @variabila INT;

CASE @variabila
	WHEN 5 THEN rez1
	WHEN val2 THEN rez2
	...
	[ELSE] default_rez
END;
*/

-- CASE CU CAUTARE
/*
DECLARE @variabila int;
SET @variabila = 7;

CASE
	WHEN @variabila < 5 THEN rez1
	WHEN @variabila > 5 THEN rez2
	...
	[ELSE] default_rez
END;
*/

SELECT Nume,
	CASE UM
		WHEN 'buc' THEN 'Bucata'
		WHEN 'litru' THEN 'Un litru'
		WHEN 'duzina' THEN 'O duzina'
		ELSE ISNULL(UM, 'N/A')
	END AS Unitate_De_Masura
FROM Produs;

-- INSERT

INSERT INTO Beneficiar
	(Oras, Nume)
	VALUES (DEFAULT, 'Fara oras lab 8'),
		('Bucuresti', DEFAULT);

		
INSERT INTO Beneficiar
	SELECT Nume, Oras FROM Beneficiar;

/*
INSERT INTO Beneficiar
	EXEC nume_procedura;
*/

INSERT INTO Beneficiar
	DEFAULT VALUES;

-- DBCC CHECKIDENT('Beneficiar', RESEED, 0);


-- DELETE

-- Stergerea beneficiarilor fara tranzactii
DELETE FROM Beneficiar
	FROM Beneficiar B LEFT JOIN Tranzactii T
		ON B.CodB = T.CodB
	WHERE T.CodT IS NULL;

-- echivalent

DELETE FROM Beneficiar
	WHERE CodB NOT IN (SELECT CodB
			FROM Tranzactii);

DELETE FROM Beneficiar;

DELETE FROM Beneficiar
	WHERE CodB = 37;

-- UPDATE

-- Setarea orasului 'Targu Mures' pentru toti beneficiarii ce nu au tranzactii
UPDATE Beneficiar
	SET Oras = 'Targu Mures'
	FROM Beneficiar B LEFT JOIN Tranzactii T
		ON B.CodB = T.CodB
	WHERE T.CodT IS NULL;

UPDATE Beneficiar
	SET Oras = NULL
	WHERE CodB = 37;

UPDATE Beneficiar
	SET Oras = NULL;

-- 4
UPDATE Oferte
	SET Pret = 
		CASE
		 WHEN Pret < 4000 THEN 0.95 * Pret
		 ELSE 0.8 * Pret
	END;

-- 5
UPDATE Oferte
	SET Pret = 
		CASE
		 WHEN Pret < 4000 THEN 0.95 * Pret
		 ELSE 0.8 * Pret
	END
	FROM Oferte O JOIN Produs P ON O.CodP = P.CodP
	WHERE P.Nume LIKE '%calc%' OR P.Nume LIKE '%auto%';

-- 6
UPDATE Oferte
	SET Pret = Pret * 1.1
	FROM Oferte O JOIN Produs P ON O.CodP = P.CodP
	WHERE P.Nume LIKE '%auto%' OR
		P.CodP IN (SELECT CodP
				FROM Oferte
				GROUP BY CodP
				HAVING COUNT(CodF) = 1
				);

-- 9.3.4
DELETE Oferte
	FROM Oferte O LEFT JOIN Tranzactii T
		ON O.CodF = T.CodF AND O.CodP = T.CodP
	WHERE T.CodT IS NULL;
