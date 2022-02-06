use Agenti;

CREATE TABLE Beneficiar(
	CodB INT  IDENTITY (1,1) NOT NULL,
	Nume VARCHAR(50) NOT NULL,
	Oras VARCHAR(50) NULL,
	CONSTRAINT PK_Beneficiar PRIMARY KEY NONCLUSTERED
	(
		CodB
	)
);

CREATE TABLE Cerere(
	CodB INT NOT NULL,
	CodP INT NOT NULL,
	Pret MONEY NULL,
	Cantitate INT NULL
	CONSTRAINT PK_Cerere PRIMARY KEY NONCLUSTERED
	(
		CodB,
		CodP
	)
);

CREATE TABLE Furnizor(
	CodF INT IDENTITY (1,1) NOT NULL,
	Nume VARCHAR(50) NOT NULL,
	Oras VARCHAR(50) NULL
	CONSTRAINT PK_Furnizor PRIMARY KEY NONCLUSTERED
	(
		CodF
	)
);

CREATE TABLE Oferte(
	CodF INT NOT NULL,
	CodP INT NOT NULL,
	Pret MONEY NULL,
	Cantitate INT NULL
	CONSTRAINT PK_Oferte PRIMARY KEY NONCLUSTERED
	(
		CodF,
		CodP
	)
);

CREATE TABLE Produs(
	CodP INT IDENTITY (1,1) NOT NULL,
	Nume varchar (50) NOT NULL,
	UM varchar (50) NULL
	CONSTRAINT PK_Produs PRIMARY KEY NONCLUSTERED
	(
		CodP
	)
);

CREATE TABLE Tranzactii(
	CodT INT IDENTITY(1,1) NOT NULL,
	CodF INT NULL,
	CodB INT NULL,
	CodP INT NULL,
	Pret MONEY NULL,
	Cantitate INT NULL
	CONSTRAINT PK_Tranzactii PRIMARY KEY NONCLUSTERED
	(
		CodT
	)
);

ALTER TABLE Cerere ADD
	CONSTRAINT PK_Cerere_Beneficiar FOREIGN KEY
	(
		CodB
	) REFERENCES Beneficiar(
		CodB
	),
	CONSTRAINT PK_Cerere_Produs FOREIGN KEY
	(
		CodP
	) REFERENCES Produs(
		CodP
	);

ALTER TABLE Oferte ADD
	CONSTRAINT PK_Oferte_Furnizor FOREIGN KEY
	(
		CodF
	) REFERENCES Furnizor(
		CodF
	),
	CONSTRAINT PK_Oferte_Produs FOREIGN KEY
	(
		CodP
	) REFERENCES Produs(
		CodP
	);

ALTER TABLE Tranzactii ADD
	CONSTRAINT PK_Tranzactii_Beneficiar FOREIGN KEY
	(
		CodB
	) REFERENCES Beneficiar(
		CodB
	),
	CONSTRAINT PK_Tranzactii_Cerere FOREIGN KEY
	(
		CodB,
		CodP
	) REFERENCES Cerere(
		CodB,
		CodP
	),
	CONSTRAINT PK_Tranzactii_Furnizor FOREIGN KEY
	(
		CodF
	) REFERENCES Furnizor(
		CodF
	),
	CONSTRAINT PK_Tranzactii_Oferte FOREIGN KEY
	(
		CodF,
		CodP
	) REFERENCES Oferte(
		CodF,
		CodP
	);