--1

SELECT name from S
ORDER by name asc;

--2

select * from P where COLOR='Red';

--3

select CITY, count(J) from J GROUP BY CITY;

--4

select spj.QTY, s.name, p.PNAME from SPJ spj INNER JOIN S s ON spj.S=s.S INNER JOIN P p ON spj.P= p.P;

--5

select S, SUM(QTY) FROM SPJ GROUP BY(S);

--12

SELECT * FROM SPJ ORDER BY QTY DESC LIMIT 3;

--13

SELECT j.J, j.JNAME, j.CITY FROM SPJ spj inner join J j on spj.J= j.J inner join P p on spj.P=p.P where p.CITY='London';

--14

select name, stats, case when stats>=30 then 'alto' when stats>=20 then 'medio' when stats>=10 then 'baixo' end as classificacao from S;

--15

SELECT S.S, S.name, S.stats, S.city
FROM SPJ spj
INNER JOIN S ON spj.S = S.S
INNER JOIN P ON spj.P = P.P
WHERE (
    SELECT COUNT(DISTINCT P)
    FROM SPJ
    WHERE SPJ.S = S.S
) = 6;


