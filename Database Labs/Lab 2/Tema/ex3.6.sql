--Exercitiul 3.6

--3.6.1
--A.
--CREATE TABLE T(A int PRIMARY KEY, B int PRIMARY KEY)
/*EROARE: Nu se pot aduga mai multe constrangeri de tipul primary key intr-o tabela
O VARIANTA CORECTE CREATE TABLE T(A int PRIMARY KEY, B int)*/


--B.
/*CREATE TABLE T3(A int NOT NULL)
	ALTER TABLE T3 ADD PRIMARY KEY(A)*/
/*EROARE: Nu poti transforma in primary key o coloana cara poate fi nula
Corect: 
CREATE TABLE T3(A int NOT NULL)
	ALTER TABLE T3 ADD PRIMARY KEY(A)
	*/


--C.
/*CREATE TABLE T4( CHECK(A<B), A int, B int)
Corect*/


--D.
/*CREATE TABLE T5(A INT PRIMARY KEY
	FOREIGN KEY REFERENCES T5(A))
Corect*/


--E.
/*CREATE TABLE T6(A int IDENTITY PRIMARY KEY)
Corect*/

--F.
/*CREATE TABLE T7(A int IDENTITY (0,0))
ERROR:Incrementul trebuie sa fie pozitiv
ex: CREATE TABLE T7(A int IDENTITY (0,1))
*/

--G.
/*CREATE TABLE T8(A int IDENTITY, B int IDENTITY)
ERROR: Nu sunt permise mai multe coloane de tip identity per tabela
*/


--3.6.2
/*CREATE TABLE
	T9(A int PRIMARY KEY FOREIGN KEY REFERENCES T9(B),
	B int UNIQUE FOREIGN KEY REFERENCES T9(A))

INSERT T9 values (2,2)  --valid
INSERT T9 values (1,3)  --invalid

--Pentru a fi acceptate tuplele trebuie sa fie egale 
*/


---3.6.4
/*use Agenti;

CREATE UNIQUE INDEX Index_Furnizor ON Furnizor(Nume)
CREATE UNIQUE INDEX Index_Beneficiar ON Beneficiar(Nume)
CREATE UNIQUE INDEX Index_Produs ON Produs(Nume)
*/


--3.6.5
/*ALTER TABLE Oferte ADD CONSTRAINT check_ferte CHECK (Pret>0 and Cantitate>0) 
ALTER TABLE Cerere ADD CONSTRAINT check_Cerere CHECK (Pret>0 and Cantitate>0) 
ALTER TABLE Tranzactii ADD CONSTRAINT check_Tranzactii CHECK (Pret>0 and Cantitate>0)
*/


--3.6.6
/*
ALTER TABLE Oferte ADD Oferta_Noua AS (0.7 * Pret)
ALTER TABLE Cerere ADD Cerere_Noua AS (Cantitate * 1.5)
ALTER TABLE Tranzactii ADD Tranzactie_Noua AS (1.2 * Pret)
*/