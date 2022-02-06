use Agenti;

--8.3.
--1.
--a)
SELECT B.Nume, COUNT(C.CodP)
FROM Beneficiar B LEFT JOIN Cerere C ON B.CodB=C.CodB
GROUP BY B.Nume;

--b)
SELECT P.Nume, 'Cereri' = COUNT(DISTINCT C.CodB), 'Oferte' = COUNT(DISTINCT O.CodF)
FROM Produs P LEFT JOIN Cerere C ON P.CodP = C.CodP
	FULL JOIN Oferte O ON P.CodP = O.CodP
GROUP BY P.Nume; 

--c)
SELECT P.Nume, 'Oferta' = ISNULL(AVG(O.Pret),0), 'Cerere' = ISNULL(AVG(C.Pret),0), 'Tranzactie' = ISNULL(AVG(T.Pret),0)
FROM Produs P LEFT JOIN Oferte O ON P.CodP = O.CodP
	LEFT JOIN Cerere C ON P.CodP = C.CodP
	LEFT JOIN Tranzactii T ON P.CodP = T.CodP
GROUP BY P.Nume;

--d)
SELECT 'Oras Furnizor' = ISNULL(F.Oras,'Nu exista legatura'), 
	'Oras Beneficiar' = ISNULL(B.Oras,'Nu exista legatura'), 
	'Nr. Tranzactii' = COUNT(T.CodT)
FROM Furnizor F FULL JOIN Tranzactii T ON F.CodF = T.CodF
	FULL JOIN Beneficiar B ON T.CodB = B.CodB
GROUP BY F.Oras,B.Oras;

--BONUS
--Fiecare produs si media valorilor ofertelor pentru ele. (Pentru ofertele fara pret specificat se trece 100.
--Pentru produsele fara cantitatea specificata se trece 10. Valoare = pret * cantitate)
SELECT P.Nume, AVG(ISNULL(O.Pret,100) * ISNULL(O.Cantitate,10))
FROM Produs P LEFT JOIN Oferte O ON P.CodP = O.CodP
GROUP BY P.Nume;

-- Fiecare furnizor si numarul de tranzactii incheiate de acesta. Pentru furnizorii fara tranzactii se trece 0.
SELECT F.Nume, 'Nr. Tranzactii' = COUNT(T.CodT)
FROM Furnizor F LEFT JOIN Tranzactii T ON F.CodF = T.CodF
GROUP BY F.Nume;

--2.
--Original
SELECT *
FROM Tranzactii CROSS JOIN 
			(Furnizor CROSS JOIN
			(Beneficiar CROSS JOIN Produs))
WHERE Furnizor.CodF = Tranzactii.CodF
	AND Beneficiar.CodB = Tranzactii.CodB
	AND Produs.CodP = Tranzactii.CodP;

--Rescris
SELECT *
FROM Tranzactii JOIN Furnizor ON Furnizor.CodF = Tranzactii.CodF
	JOIN Beneficiar ON Beneficiar.CodB = Tranzactii.CodB
	JOIN Produs ON Produs.CodP = Tranzactii.CodP;