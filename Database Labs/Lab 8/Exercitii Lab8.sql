use Agenti;
--Ex 9.3.3
UPDATE Oferte 
	SET Pret = 0.9*Pret
FROM Oferte
WHERE (SELECT COUNT(O.CodP)
	FROM Oferte O 
	WHERE Oferte.CodP = O.CodP)>=2
			

--Ex 9.3.5
UPDATE Oferte
	SET Pret=
	CASE
		WHEN Cantitate > 10000000 THEN 0.8*Pret
		WHEN (P.UM = 'tona' AND Cantitate > 100) THEN 0.8*Pret
		ELSE Pret
	END
FROM OFERTE JOIN Produs P ON P.CodP = Oferte.CodP
WHERE Pret > 1000;
