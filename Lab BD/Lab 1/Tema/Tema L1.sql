/*
--Exercitiul 1
DECLARE @b BINARY;
DECLARE @c CHAR;
DECLARE @i INT;
DECLARE @s SQL_VARIANT;

SET @b=0x31;
SET @c='A';
SET @i=49;
SET @s='abc';
SET @c=@b;
SET @c=@i;
SET @b=@c;  --FALS
SET @s=@b;
SET @c=@s;  --FALS
*/


--Exercitiul 2
/*
--a)
DECLARE @x BINARY;
DECLARE @y INT;
SET @x=0x11;
SET @y=@x;
SELECT @y;
--valoare afisata: 17
*/
/*
--b)
DECLARE @x BINARY(2);
DECLARE @y SMALLINT;
SET @x=0xFFE1;
SET @y=@x;
SELECT @y;
--valoare afisata: -31
*/

/*
--Exercitiul 3
DECLARE @x TABLE(a INT); 
SET @x=1;  
SELECT @x;

--Variabile x trebuie sa fie de tipul scalar, nu table
*/


--Exercitiul 4
--Initial
DECLARE @a,@b INT;  
SET @a=1,@b=2;

--Varianta corecta
DECLARE @a INT,@b INT;  
SET @a=1;
SET @b=2;