use Agenti;

GO

-- vedere care concateneaza numele si orasul beneficiarilor astfel: Nume - Oras
CREATE VIEW sgr1_view1 (Nume_Oras)
AS
	SELECT Nume + ' - ' + Oras
	FROM Beneficiar;
	-- NU PUTEM - ORDER BY
	-- NU PUTEM - SELECT ... INTO
	-- NU putem folosi tabele temporare

GO

SELECT * FROM sgr1_view1;

GO

-- view cu fiecare beneficiar si numarul de cereri
CREATE VIEW sgr1_view2
AS
	SELECT B.Nume, B.Oras, COUNT(CodP) AS Numar_Cereri
	FROM Beneficiar B LEFT JOIN Cerere C
		ON B.CodB = C.CodB
	GROUP BY B.Nume, B.Oras;

GO

SELECT * FROM sgr1_view2;

GO

ALTER VIEW sgr1_view1 (Nume_Oras)
AS
	SELECT Nume + ' - ' + ISNULL(Oras, 'Fara Oras')
	FROM Beneficiar;

GO 

SELECT * FROM sgr1_view1;

GO

-- DROP VIEW sgr1_view1, sgr1_view2;

GO

-- UPDATABLE VIEWS

CREATE VIEW updatable_view 
AS
	SELECT B.CodB, B.Nume
	FROM Beneficiar B JOIN Tranzactii T
		ON B.CodB = T.CodB;

GO

UPDATE updatable_view
	SET Nume = 'Ceva nume'
	WHERE CodB = 1;

INSERT INTO updatable_view VALUES (NULL);

go

CREATE VIEW updatable_view2
AS
	SELECT B.CodB, B.Nume, T.CodT
	FROM Beneficiar B JOIN Tranzactii T
		ON B.CodB = T.CodB;

GO

INSERT INTO updatable_view (Nume) VALUES ('Ceva nume 2');

-- EXERCITII INDRUMATOR - LAB 8
-- a
GO

CREATE VIEW l8_a_1
AS
	SELECT F.Nume, AVG(O.Pret * O.Cantitate) AS Medie_Valori_Oferte
	FROM Furnizor F LEFT JOIN Oferte O
		ON F.CodF = O.CodF
	GROUP BY F.Nume;

GO

SELECT * FROM l8_a_1;

GO

-- b
CREATE VIEW l8_b_1
AS
	SELECT B.Nume
	FROM Beneficiar B
	WHERE B.Oras = 'Oradea' AND B.CodB IN
		(SELECT CodB
		FROM Tranzactii T JOIN Produs P ON T.CodP = P.CodP
		WHERE P.Nume LIKE '%calculator%')
		AND B.CodB NOT IN
		(SELECT CodB
		FROM Tranzactii T JOIN Produs P ON T.CodP = P.CodP
		WHERE P.Nume LIKE '%memory%')

GO

SELECT * FROM l8_b_1;






