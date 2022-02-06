use Agenti;

CREATE TABLE Birouri (
	Id_b INT PRIMARY KEY,
	Oras VARCHAR(50) NOT NULL
);

CREATE TABLE Angajati (
	Id_a INT PRIMARY KEY,
	Nume VARCHAR(50) NOT NULL,
	Prenume VARCHAR(50) NOT NULL,
	Varsta INT NOT NULL CHECK (Varsta > 0),
	Salariu DECIMAL NOT NULL,
	Id_birou INT FOREIGN KEY REFERENCES Birouri (Id_b)
);

GO

INSERT INTO Birouri VALUES 
	(1, 'Cluj-Napoca'),
	(2, 'Timisoara'),
	(3, 'Bucuresti'),
	(4, 'Iasi');

GO

INSERT INTO Angajati VALUES
	(1, 'Popa', 'Alex', 18, 1000, 1),
	(2, 'Popa', 'Mihai', 22, 1233, 2),
	(3, 'Popa', 'Rares', 21, 4230, 3),
	(4, 'Ciubuc', 'Alex', 19, 5243, 1),
	(5, 'Domsa', 'Radu', 27, 2000, 2),
	(6, 'Vlas', 'Tudor', 35, 3000, 3),
	(7, 'Duca', 'Bogdan', 33, 5000, 1),
	(8, 'Ciubuc', 'Bogdan', 35, 9000, 2),
	(9, 'Bozdog', 'Marian', 30, 8700, 3),
	(10, 'Bozdog', 'Andrei', 25, 4000, 1),
	(11, 'Crisan', 'Ovidiu', 24, 1000, 2),
	(12, 'Stoian', 'Adrian', 32, 15000, 3),
	(13, 'Pop', 'Flavius', 29, 5000, null);