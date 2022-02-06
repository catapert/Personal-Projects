use Agenti;

GO

-- Sa nu se poata insera furnizori care au numele orasului mai lung de 15 de caractere
CREATE TRIGGER sgr2_tr1
ON Furnizor
AFTER INSERT
AS
BEGIN
	-- inserted
	-- deleted
	SET NOCOUNT ON;
	IF (@@ROWCOUNT = 0)
		PRINT 'Nu au fost inserati furnizori';
	IF EXISTS(SELECT *
		FROM inserted
		WHERE LEN(Oras) > 15)
		BEGIN
			RAISERROR('Nu se pot insera furnizori cu numele orasului mai lung de 15 caractere!', 16, 0);
			ROLLBACK TRANSACTION;
		END
	ELSE
		PRINT 'Toti furnizorii sunt ok!';
END

GO

INSERT INTO Furnizor VALUES ('Nume frz', 'Oras 15 chr');

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
GO
CREATE TRIGGER ex_a
ON Furnizor
FOR INSERT, UPDATE
AS
BEGIN
	IF EXISTS(SELECT *
		FROM inserted
		WHERE Nume NOT LIKE 'F%')
		Begin
			RAISERROR('Numele furnizorului incepe cu o litera diferita de F',16,1)
			ROLLBACK TRANSACTION
		END
END


-- c
CREATE TABLE History_tranzactii (
	CodT INT PRIMARY KEY,
	CodF INT,
	CodB INT,
	CodP INT,
	Pret MONEY,
	Cantitate INT
);

GO

CREATE TRIGGER ex_c
ON Tranzactii
FOR DELETE
AS
BEGIN
	IF EXISTS(SELECT *
	FROM deleted)
		BEGIN
			INSERT INTO History_tranzactii
			SELECT * FROM deleted
		END
END


-- hint pentru trigger
INSERT INTO History_tranzactii
	SELECT * FROM deleted;

-- Chestie extra
-- Tine numarul de tuple modificate de ultima operatie pe baza de date
-- @@ROWCOUNT
