use Agenti
--c)
GO
CREATE VIEW view_c
AS
	SELECT Nume_Furnizor=F.Nume, Nume_Beneficiar=B.Nume,  Nume_Produs=P.Nume, T.Cantitate, T.Pret 
	FROM Furnizor F JOIN Tranzactii T ON F.CodF = T.CodF
		JOIN Beneficiar B ON B.CodB = T.CodB
		JOIN Produs P ON P.CodP = T.CodP
	WHERE F.Oras = 'Cluj' AND
		B.Oras = 'BucurestI'
GO

SELECT *
FROM view_c
GO

--d)
CREATE VIEW view_d
AS
	SELECT B.Nume, COUNT(C.CodB) AS Numar_Cereri
	FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	WHERE B.Oras = 'Bucuresti'
	GROUP BY B.Nume
GO

SELECT *
FROM view_d
GO

--e)
/*
--Tentativa
SELECT Oras_oferte = F.Oras, Oras_cereri = B.Oras, Nr_oferte=COUNT(DISTINCT O.CodP), Nr_cereri = COUNT(DISTINCT C.CodP),
	Nr_tranzactii_oras_oferte = COUNT(DISTINCT T.CodT), Nr_tranzactii_oras_cereri = COUNT(DISTINCT T.CodT)
	FROM Furnizor F FULL JOIN Oferte O ON F.CodF = O.CodF
		FULL JOIN Tranzactii T ON T.CodF = O.CodF
		FULL JOIN Cerere C ON C.CodB = T.CodB
		FULL JOIN Beneficiar B ON T.CodB = B.CodB
	GROUP BY F.Oras, B.Oras;
*/
CREATE VIEW view_e_oferte
AS
	SELECT Oras_oferte = F.Oras,Nr_oferte=COUNT(DISTINCT O.CodP), Nr_tranzactii_oras_oferte = COUNT(DISTINCT T.CodT)
	FROM Furnizor F FULL JOIN Oferte O ON F.CodF = O.CodF
		FULL JOIN Tranzactii T ON T.CodF = F.CodF
	GROUP BY F.Oras
GO


CREATE VIEW view_e_cereri
AS
SELECT Oras_cereri = B.Oras, Nr_cereri = COUNT(DISTINCT C.CodP), Nr_tranzactii_oras_cereri = COUNT(DISTINCT T.CodT)
	FROM Beneficiar B FULL JOIN Cerere C ON B.CodB = C.CodB
		FULL JOIN Tranzactii T ON B.CodB = T.CodB
	GROUP BY B.Oras;
GO

SELECT *
FROM view_e_cereri
GO

SELECT *
FROM view_e_oferte
GO

--ata ete