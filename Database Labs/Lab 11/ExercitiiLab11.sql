use Agenti;

--Indrumator nou
--a)
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

INSERT Furnizor VALUES ('Furnizor nou', 'Oras x')

--c)
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

SELECT *
FROM History_tranzactii;

--b)
GO
CREATE TRIGGER ex_b
ON Oferte
FOR DELETE
AS
BEGIN
	IF EXISTS(SELECT *
		FROM deleted JOIN Produs P ON P.CodP = deleted.CodP
		WHERE P.Nume LIKE '%calculator%')
		BEGIN
			RAISERROR('Nu pot fi sterse ofertele pentru calculatoare',16,1)
			ROLLBACK TRANSACTION
		END
	ELSE
		PRINT 'Nu au fost sterse oferte pentru calculatoare'
END

--d)
GO
CREATE TRIGGER ex_d
ON Cerere
FOR UPDATE
AS
BEGIN 
	IF UPDATE(Pret)
	BEGIN
		RAISERROR('Nu poate fi modificata coloana Pret!',16,1)
		ROLLBACK TRANSACTION
	END	
END

