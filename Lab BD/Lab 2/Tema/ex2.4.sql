--Exercitiu 2.4.1
/*
SELECT POWER(1,0.5) --Returneaza 1
SELECT SQRT(9) --Returneaza 3

SELECT ROUND(748,-1) --Returneaza 750
SELECT ROUND(48.58,1) --Returneaza 48.6
SELECT ROUND(78.344,1) --Returneaza 78.3
SELECT ROUND(701,-2)  --Returneaza 700
SELECT ROUND(12.12,2)  --Returneaza 12.12
*/
/*
SELECT CHARINDEX('aa','aaaaaaa')  --Returneaza 1
SELECT CHARINDEX('aa','aaaaaaa',4)  --Returneaza 4

SELECT LEFT('abcdef',2)  --Returneaza ab
SELECT RIGHT('abcdef',4)  --Returneaza cdef
SELECT SUBSTRING('abcdef',2,3)  --Returneaza bcd
*/
/*
SELECT REPLACE('abcabcabc','a','abc')  --Returneaza abcbcabcbcabcbc

SELECT CAST('123' AS char(2))  --Returneaza 12

SELECT CAST('07/13/01' AS datetime)  --Returneaza 2001-07-13 00:00:00.000
SELECT CONVERT(varchar(12), CAST('07/06/01' AS datetime),1)  --Returneaza 07/06/01 
SELECT CONVERT(varchar(12), CAST('07/06/01' AS datetime),101)  --Returneaza 07/06/2001
SELECT CONVERT(varchar(12), CONVERT(datetime,'07/06/01',1),6)  --Returneaza 06 Jul 01
SELECT CONVERT(varchar(12), CONVERT(datetime,'07/06/01',3),6)  --Returneaza 07 Jun 01
*/

