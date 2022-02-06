--Tema Capitol 4.9
--Ex1
use Agenti
IF (EXISTS (SELECT * FROM Furnizor) AND EXISTS (SELECT * FROM Produs) AND EXISTS (SELECT * FROM Oferte) )
SELECT Furnizor.Nume, Produs.Nume,Pret,Cantitate 
	FROM Furnizor, Oferte, Produs
	WHERE Furnizor.CodF = Oferte.CodF
		AND Oferte.CodP = Produs.CodP


--Ex2 
IF NOT EXISTS (SELECT * FROM Furnizor)
BEGIN
	PRINT 'Tabela este vida!'
	RETURN
END
IF NOT EXISTS (SELECT * FROM Produs)
BEGIN
	PRINT 'Tabela este vida!'
	RETURN
END
IF NOT EXISTS (SELECT * FROM Oferte)
BEGIN
	PRINT 'Tabela este vida!'
	RETURN
END
SELECT Furnizor.Nume, Produs.Nume,Pret,Cantitate 
	FROM Furnizor, Oferte, Produs
	WHERE Furnizor.CodF = Oferte.CodF
		AND Oferte.CodP = Produs.CodP


--Ex3
use Agenti
IF EXISTS (SELECT * FROM Furnizor)
	IF EXISTS (SELECT * FROM Produs)
		IF EXISTS (SELECT * FROM Oferte)
		SELECT Furnizor.Nume,Produs.Nume,Pret,Cantitate
			FROM Furnizor, Oferte, Produs
			WHERE Furnizor.CodF = Oferte.CodF
				AND Oferte.CodP = Produs.CodP
		ELSE
		PRINT 'Tabela Oferte este vida!'
	ELSE 
	PRINT 'Tabela Produs este vida!'
ELSE
PRINT 'Tabela Furnizor este vida!'


--Ex4

WHILE (DATEPART (ss, GETDATE())<>0)
	BEGIN
		WAITFOR DELAY '00:00:01'
	END
PRINT DATEPART(mm, GETDATE())