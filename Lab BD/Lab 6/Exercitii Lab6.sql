use Agenti 

--Exercitii 7.2
--7.2.1
--a)
SELECT B.Oras, COUNT(*)
FROM Beneficiar B
GROUP BY B.Oras;

--b)
SELECT B.Oras, COUNT(*)
FROM Beneficiar B JOIN Tranzactii T ON T.CodB=B.CodB
GROUP BY B.Oras;

--c)
SELECT P.Nume, COUNT(O.CodF)
FROM Produs P JOIN Oferte O ON P.CodP=O.CodP
GROUP BY P.Nume;

--d)
SELECT P.Nume, AVG(O.Pret), SUM(O.Cantitate)
FROM Produs P JOIN Oferte O ON P.CodP=O.CodP
GROUP BY P.Nume;

--e)
SELECT F.Nume, B.Nume
FROM Furnizor F JOIN Tranzactii T ON F.CodF= T.CodF
	JOIN Beneficiar B ON T.CodB=B.CodB
WHERE F.Oras=B.Oras
GROUP BY F.Nume, B.Nume;

--f)
SELECT F.Nume, B.Nume, F.Oras
FROM Furnizor F JOIN Tranzactii T ON F.CodF= T.CodF
	JOIN Beneficiar B ON T.CodB=B.CodB
WHERE F.Oras=B.Oras
GROUP BY F.Nume, B.Nume, F.Oras;

--g)
SELECT F.Oras, B.Oras,COUNT(*)
FROM Furnizor F JOIN Tranzactii T ON F.CodF= T.CodF
	JOIN Beneficiar B ON T.CodB=B.CodB
GROUP BY F.Oras, B.Oras;

--BONUS
--1. Cantitatea totala din fiecare produs tranzactionat de furnizorul cu id-ul 1.
SELECT P.Nume, SUM(T.Cantitate)
FROM Tranzactii T JOIN Produs P ON P.CodP=T.CodP
WHERE T.CodF=1
GROUP BY P.Nume

--2. Pretul mediu cerut pentru fiecare produs.
SELECT P.Nume, AVG(C.Pret)
FROM Cerere C JOIN Produs P ON P.CodP=C.CodP
GROUP BY P.Nume

--3. Numele furnizorului impreuna cu pretul mediu oferit de el pentru produse.
SELECT F.Nume,P.Nume, AVG(O.Pret)
FROM Furnizor F JOIN Oferte O ON F.CodF=O.CodF
	JOIN Produs P ON P.CodP=O.CodP
GROUP BY F.Nume,P.Nume

--4. Numele produsului si numarul de cereri pentru el, care au un pret mai mic decat 500.
SELECT P.Nume, COUNT(*)
FROM Produs P JOIN Cerere C ON P.CodP=C.CodP
WHERE C.Pret<500
GROUP BY P.Nume

--5. Numele produsului si valoarea totala a tranzactiilor facute cu el.
SELECT P.Nume,SUM(T.Pret)*SUM(T.Cantitate)
FROM Produs P JOIN Tranzactii T ON P.CodP=T.CodP
GROUP BY P.Nume

--6. Numarul de produse tranzactionate de fiecare furnizor.
SELECT F.Nume, SUM(T.Cantitate)
FROM Produs P JOIN Tranzactii T ON P.CodP=T.CodP
	JOIN Furnizor F ON T.CodF=F.CodF
GROUP BY F.Nume


--7. Lista perechilor frunizor - beneficiar care au incheiat tranzactii si ale caror nume de orase incep cu literele B sau C.
SELECT F.Nume, B.Nume, F.Oras, B.Oras
FROM Furnizor F JOIN Tranzactii T ON F.CodF= T.CodF
	JOIN Beneficiar B ON T.CodB=B.CodB
WHERE F.Oras LIKE 'B%' OR F.Oras LIKE 'F%'
	AND B.Oras LIKE 'B%' OR B.Oras LIKE 'F%'
GROUP BY F.Nume, B.Nume, F.Oras, B.Oras;