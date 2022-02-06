use Agenti;

-- 11.6.1
--a)
GO
CREATE PROC ex1a
(
	@nume_produs VARCHAR(55),
	@pretul_total REAL OUTPUT
)
AS
BEGIN
	SELECT @pretul_total = SUM(O.Pret)
	FROM Oferte O JOIN Produs P ON O.CodP = P.CodP
	WHERE P.Nume = @nume_produs
	GROUP BY P.Nume
END
GO

DECLARE @pret_total REAL;

EXEC ex1a 'Oua', @pret_total OUTPUT;

PRINT @pret_total;

--b)
GO
ALTER PROC ex1a
(
	@nume_produs VARCHAR(55),
	@pretul_total REAL OUTPUT,
	@val_medie REAL OUTPUT
)
AS
BEGIN
	SELECT @pretul_total = SUM(O.Pret), @val_medie = AVG(O.Pret*O.Cantitate)
	FROM Oferte O JOIN Produs P ON O.CodP = P.CodP
	WHERE P.Nume = @nume_produs
	GROUP BY P.Nume
END
GO

DECLARE @pret_total REAL;
DECLARE @val_med REAL;

EXEC ex1a 'Oua', @pret_total OUTPUT, @val_med OUTPUT;

PRINT @pret_total;
PRINT @val_med;


-- PDF
-- a)
GO
CREATE PROC L9_a
(
	@nume_furnizor VARCHAR(55)
)
AS
BEGIN
	SELECT F.Nume, B.Nume, P.Nume, T.Cantitate, T.Pret
	FROM Furnizor F JOIN Tranzactii T ON F.CodF = T.CodF
		JOIN Beneficiar B ON B.CodB = T.CodB
		JOIN Produs P ON P.CodP = T.CodP
	WHERE F.Nume = @nume_furnizor
END;

EXEC L9_a 'Furnizor 1'

-- b)
GO
CREATE PROC L9_b
(
	@nume_furnizor VARCHAR(55),
	@CodF INT OUTPUT,
	@nume_produs VARCHAR(55),
	@CodP INT OUTPUT,
	@cantitate REAL,
	@pret REAL
)
AS
	SET @CodF = (SELECT F.CodF
			FROM Furnizor F
			WHERE F.Nume = @nume_furnizor)

	SET @CodP = (SELECT P.CodP
			FROM Produs P
			WHERE P.Nume = @nume_produs)

	INSERT INTO Oferte
		(Cantitate,CodF,CodP,Pret)
		VALUES (@cantitate, @CodF, @CodP,@pret)
;
DECLARE @CodPR INT;
DECLARE @CodFu INT;
EXEC L9_b 'Furnizor 3', @CodFu OUTPUT, 'Lapte', @CodPR OUTPUT, 1500, 450;

-- c)
GO
CREATE PROC L9_c
(
	@nume_produs VARCHAR(55)
)
AS
	UPDATE Cerere
		SET Pret = 0.75*Pret
		FROM Cerere JOIN Produs P ON Cerere.CodP = P.CodP
		WHERE P.Nume = @nume_produs
;

EXEC L9_c 'Oua'

-- d)
GO 
CREATE PROC L9_d
(
	@prag_pret REAL
)
AS
	UPDATE Oferte
		SET Cantitate = Cantitate-1
		FROM Oferte  JOIN Produs P ON P.CodP = Oferte.CodP
		WHERE Oferte.Pret > @prag_pret 
			AND P.UM LIKE 'buc%'
;
EXEC L9_d 1000
		
