use Agenti;

-- CASE SIMPLU
/*
CASE expresie
	WHEN val1 THEN expr1
	WHEN val2 THEN expr2
	...
	[ELSE] expr_default;
*/

-- CASE CU CAUTARE
/*
CASE
	WHEN expr_bol1 THEN expr1
	WHEN expr_bol2 THEN expr2
	...
	[ELSE] expr_default;
*/

-- ex de expr_bol: @variabila < 5

SELECT Nume, 
	CASE UM	
		WHEN 'buc' THEN 'Bucata'
		WHEN 'litru' THEN 'Un litru'
		WHEN 'duzina' THEN 'O duzina'
		ELSE ISNULL(UM, 'Nespecificat')
	END AS Unitate_De_Masura
FROM Produs;

-- INSERT
-- INSERT INTO = INSERT
INSERT INTO Beneficiar 
	(Oras, Nume)
	VALUES ('Bucuresti', 'Vasile Ion'),
		('Petrosani', 'Alex Mihai');

INSERT INTO Beneficiar
	SELECT Nume, Oras FROM Beneficiar;

INSERT INTO Beneficiar
	EXEC PROC_STC;

INSERT INTO Beneficiar
	DEFAULT VALUES;

-- DELETE

-- Stergerea beneficiarilor fara tranzactii
DELETE FROM Beneficiar
	FROM Beneficiar B LEFT JOIN Tranzactii T ON B.CodB = T.CodB
	WHERE T.CodT IS NULL;

-- echivalent cu

DELETE FROM Beneficiar
	WHERE CodB NOT IN (SELECT CodB FROM Tranzactii);

-- Stergerea benef fara oras
DELETE FROM Beneficiar
	WHERE Oras IS NULL;

DELETE FROM Beneficiar
	WHERE CodB = 13;

-- Stegerea ultimului beneficiar introdus
DELETE FROM Beneficiar	
	WHERE CodB = (SELECT MAX(CodB) FROM Beneficiar);


-- UPDATE

DECLARE @variabila VARCHAR(50);

UPDATE Beneficiar
	SET @variabila = Oras = 'Targu Mures'
	FROM Beneficiar B LEFT JOIN Tranzactii T ON B.CodB = T.CodB
	WHERE T.CodT IS NULL;

UPDATE Beneficiar
	SET Oras = NULL
	WHERE CodB = 12;

UPDATE Beneficiar
	SET Oras = NULL

-- Stergerea ofertelor pentru care nu sunt tranzactii
DELETE FROM Oferte
	FROM Oferte O LEFT JOIN Tranzactii T
		ON O.CodP = T.CodP AND O.CodF = T.CodF
	WHERE T.CodT IS NULL;


