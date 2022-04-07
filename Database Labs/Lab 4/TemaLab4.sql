--Tema Lab4
use Agenti
--Ex 5.10.1
--a)
SELECT Oras, COUNT(CodF)
FROM Furnizor
GROUP BY Oras
HAVING Nume="Furnizor1"
--Semnul " " trebuie inlocui cu ' '
--Coloana Furnizor.Nume trebuia sa apara in funtia de agregare sau in clauza GROUP BY

--b)
use Agenti
SELECT Furnizor.*, COUNT(CodF)
FROM Furnizor
GROUP BY Oras
HAVING Nume="Furnizor1"
--Semnul " " trebuie inlocui cu ' '
--Coloana Furnizor.Nume trebuia sa apara in funtia de agregare sau in clauza GROUP BY

--c)
use Agenti
SELECT Oras, COUNT(CodF)
FROM Furnizor
-- Oras trebuie sa fie inclus intr-o clauza de tip GROUP BY sau o functie de agragare

--d)
use Agenti
SELECT ALL DISTINCT Nume
FROM Furnizor
--ALL si DISTINCT nu pot fi folosite in acelasi timp

--e)
use Agenti
SELECT Oras
FROM Furnizor
ORDER BY Oras
UNION
SELECT Oras
FROM Beneficiar
ORDER BY Oras
--ORDER BY nu poate sa apara inaite de UNION

--f)
use Agenti
(SELECT Oras
FROM Furnizor)
MINUS
(SELECT Oras
FROM Beneficiar)
-- MINUS nu este implementat in SQL Server

--g)
use Agenti
SELECT COUNT(DISTINCT *)
FROM Furnizor
-- * nu poate fi folosit cu optiunea DISTINCT


--Ex 5.10.2
--a)
(SELECT Oras
FROM Furnizor)
UNION
(SELECT Oras
FROM Beneficiar) 
--b)
(SELECT Oras
FROM Furnizor)
UNION ALL
(SELECT Oras
FROM Beneficiar)
--c)
(SELECT DISTINCT Oras
FROM Furnizor)
UNION
(SELECT DISTINCT Oras
FROM Beneficiar)
--d)
(SELECT DISTINCT Oras
FROM Furnizor)
UNION ALL
(SELECT DISTINCT Oras
FROM Beneficiar)

-- In cazurile b si d se obtin toate orasele din ambele tabele, chiar daca sunt dublicate, ceea ce nu are loc la a si c
-- In cazurile a si b se obtin toate orasele din fiecare tabela individual, inclusiv dublicatele, iar la c si d nu se iau dublicatele 

--Ex 5.10.4
--a)
SELECT Nume, COUNT(CodP)
FROM Furnizor LEFT JOIN OFERTE ON Furnizor.CodF=Oferte.CodF
GROUP BY Nume
--b)
SELECT Nume, COUNT(*)
FROM Furnizor LEFT JOIN OFERTE ON Furnizor.CodF=Oferte.CodF
GROUP BY Nume
--In ambele exemple sunt luate toate tuplele din tabelul Furnizor datorita operatiei LEFT JOIN
--In exemplul a se numara cazurile in care este prezent un element pe colocana CodP, 
--iar pt b se numara tuplele aparute pentru fiecare furnizor chiar daca in coloanele din Oferte apare null


