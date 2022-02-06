use Agenti;

GO

-- view care concateneaza numele si orasul beneficiarilor (Nume - Oras)
CREATE VIEW sgr2_view1 (Nume_Oras)
AS
	SELECT Nume + ' - ' + Oras
	FROM Beneficiar
	-- ORDER BY
	-- SELECT ... INTO
	-- x Temporary tables

GO

SELECT * FROM sgr2_view1;

GO

CREATE VIEW sgr2_view2
AS
	SELECT B.Nume, B.Oras, COUNT(CodP) AS Numar_Cereri
	FROM Beneficiar B LEFT JOIN Cerere C 
		ON B.CodB = C.CodB
	GROUP BY B.Nume, B.Oras

GO

SELECT * FROM sgr2_view2;

GO

ALTER VIEW sgr2_view1
WITH ENCRYPTION
AS
	SELECT Nume + ' - ' + ISNULL(Oras, 'Fara Oras') AS ORAS
	FROM Beneficiar 
WITH CHECK OPTION

GO

SELECT * FROM sgr2_view1;

GO

-- DROP VIEW sgr2_view1;


-- UPDATABLE VIEWS

CREATE VIEW sgr2_updatable
AS
	SELECT Nume, Oras
	FROM Furnizor;

GO

INSERT INTO sgr2_updatable VALUES ('Furnizor prin view', 'Bucuresti');
-- NU MERGE - INSERT INTO sgr2_view2 VALUES ('Ben prin vies', 'Cluj-Napoca', -);

GO

ALTER VIEW sgr2_updatable
AS
	SELECT Nume, Oras
	FROM Furnizor JOIN Oferte
		ON Furnizor.CodF = Oferte.CodF;

GO

INSERT INTO sgr2_updatable VALUES ('Furnizor prin view cu join', 'Bucuresti');

-- EXERCITII PDF - LAB 8

-- a
GO

CREATE VIEW l8_a_2
AS
	SELECT F.Nume, ISNULL(AVG(O.Pret * O.Cantitate), 0) AS Medie_Valori
	FROM Furnizor F LEFT JOIN Oferte O
		ON F.CodF = O.CodF
	GROUP BY F.Nume;

GO

SELECT * FROM l8_a_2;

GO

CREATE VIEW l8_b_2
AS
	SELECT B.Nume
	FROM Beneficiar B
	WHERE B.Oras = 'Cluj' AND (
	B.CodB IN(SELECT CodB
	FROM Tranzactii JOIN PRODUS ON Tranzactii.CodP=Produs.CodP
	WHERE Produs.Nume like '%calculator%'
	)
	AND
	B.CodB NOT IN (SELECT CodB
	FROM Tranzactii JOIN PRODUS ON Tranzactii.CodP=Produs.CodP
	WHERE Produs.Nume like '%automobil%'
	)
	)