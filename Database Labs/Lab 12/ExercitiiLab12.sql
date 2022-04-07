use Agenti;
-- Exercitii Recapitulative
-- 1.Numele furnizorilor si numarul de tranzactii incheiate de fiecare furnizor cu beneficiarii din Bucuresti. 
--Pentru furnizorii fara asemenea tranzactii se va trece 0.
SELECT F.Nume, COUNT(T.CodT)
FROM Furnizor F LEFT JOIN (Tranzactii T JOIN Beneficiar B ON B.CodB = T.CodB 
	AND B.Oras LIKE 'Bucuresti') ON F.CodF = T.CodF
GROUP BY F.Nume

-- 2.Numele beneficiarilor care au atat cereri de calculatoare, cat si de memory-stick-uri.
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON P.CodP = C.CodP
WHERE P.Nume LIKE '%calculator%'
INTERSECT
SELECT B.Nume
FROM Beneficiar B JOIN Cerere C ON B.CodB = C.CodB
	JOIN Produs P ON P.CodP = C.CodP
WHERE P.Nume LIKE '%memory stick%';

-- 3.Creati in SQL Server o vedere care sa afiseze numele furnizorilor, numele beneficiarilor
--si numele produselor tranzactionate facute pe produse de tip 'calculator'.
GO
CREATE VIEW view_ex3
AS
	SELECT Nume_Furnizor = F.Nume, Nume_Beneficiar = B.Nume, Nume_Produs = P.Nume
	FROM Furnizor F JOIN Tranzactii T ON F.CodF = T.CodF
		JOIN Beneficiar B ON B.CodB = T.CodB
		JOIN Produs P ON P.CodP = T.CodP
	WHERE P.Nume LIKE '%Calculator%'
GO

SELECT *
FROM view_ex3
GO

-- 4.Creati o procedura stocata care primeste ca parametru numele produsului si afiseaza ofertele existente 
--pentru acel produs: nume furnizor, nume beneficiar, cantitate, pret.
CREATE PROC ex4
(
	@nume_produs VARCHAR(55)
)
AS
BEGIN
	SELECT F.Nume, O.Cantitate, O.Pret
	FROM Furnizor F JOIN Oferte O ON F.CodF = O.CodF
		JOIN Produs P ON P.CodP = O.CodP
	WHERE P.Nume = @nume_produs
END
GO

EXEC ex4 'Oua'

-- 5.Creati o procedura stocata pentru inserare in tabela Cereri, 
--cu urmatorii parametri: nume beneficiar, nume produs, cantitate, pret.
CREATE PROC ex5
(
	@nume_beneficiar VARCHAR(55),
	@nume_produs VARCHAR(55),
	@cantitate INT,
	@pret MONEY
)
AS
BEGIN
	DECLARE @CodB INT
	DECLARE @CodP INT
	SET @CodB = (SELECT B.CodB
			FROM Beneficiar B
			WHERE B.Nume = @nume_beneficiar)
	SET @CodP = (SELECT P.CodP
			FROM Produs P
			WHERE P.Nume = @nume_produs)
	INSERT INTO Cerere
		VALUES (@CodB, @CodP, @pret, @cantitate)
END
GO

EXEC ex5 'Beneficiar 4' , 'Oua', 100, 200

-- 6.Creati un trigger la stergere pe produse: sa nu se poata sterge produsele din categoria
--“calculatoare”.
GO
CREATE TRIGGER ex6
ON Produs
FOR DELETE
AS
BEGIN
	IF EXISTS(SELECT *
		FROM deleted
		WHERE Nume LIKE '%Calculator%')
	BEGIN
		RAISERROR('Nu pot fi sterse produsele din categoria "calculatoare"!',16,1)
		ROLLBACK TRANSACTION
	END
END


-- 7.Creati un trigger la inserare pe tabela tranzactii care sa afiseze, 
--pentru fiecare tranzactie inserata, numarul total de tranzactii din baza de date.
GO
CREATE TRIGGER ex7
ON Tranzactii
FOR INSERT
AS
BEGIN
	DECLARE @counter INT
	SET @counter = (SELECT COUNT(*)
			FROM Tranzactii)
	PRINT @counter
END

INSERT INTO Tranzactii	
	VALUES (3, 3, 4, 284, 66)
