use Agenti;

GO

-- Sa nu se poata insera furnizori care au numele orasului mai lung de 15 de caractere
CREATE TRIGGER sgr1_tr1
ON Furnizor
AFTER INSERT
AS
BEGIN
	-- inserted
	-- deleted
	SET NOCOUNT ON;
	IF EXISTS (SELECT *
		FROM inserted
		WHERE LEN(Oras) > 15)
		BEGIN
			RAISERROR('Nu se pot insera in baza de date furnizori cu numele orasului mai mare de 15 caractere!', 13, 2);
			ROLLBACK TRANSACTION;
		END
	ELSE
		PRINT 'Toti furnizorii inserati sunt ok!';
END

GO

INSERT INTO Furnizor VALUES ('Ceva furnizor nou', 'Ceva oras scurt');

GO

DROP TRIGGER sgr2_tr1;

GO

CREATE TRIGGER exemplu2_carte
ON Furnizor
FOR INSERT, UPDATE 
AS
BEGIN
	IF EXISTS(SELECT *
		FROM Furnizor F JOIN inserted i ON F.CodF <> i.CodF
		WHERE F.Nume = i.Nume)
 
		ROLLBACK TRANSACTION;
END

-- a
go

CREATE TRIGGER ex_a
ON Furnizor
AFTER INSERT
AS
BEGIN
	IF EXISTS (
		SELECT *
		FROM inserted
		WHERE Nume NOT LIKE 'F%'
	)
	BEGIN
		RAISERROR('Exista f care nu incepe cu F', 10, 2);

		ROLLBACK TRANSACTION;
	END;
END;


-- c
/*
CREATE TABLE History_tranzactii (
	CodT INT PRIMARY KEY,
	CodF INT,
	CodB INT,
	CodP INT,
	Pret MONEY,
	Cantitate INT
);
*/
/*
INSERT INTO History_tranzactii
	SELECT * FROM deleted;
*/
GO

CREATE TRIGGER ex_c
ON Tranzactii
AFTER DELETE
AS
BEGIN
	IF EXISTS (SELECT * FROM deleted)
		PRINT 'Nu au fost modificate tuple';
	ELSE
	BEGIN
		INSERT INTO History_tranzactii
			SELECT * FROM deleted;
		PRINT 'Tuplele au fost adaugate in istoric cu succes';
	END;
END

-- @@ROWCOUNT 

