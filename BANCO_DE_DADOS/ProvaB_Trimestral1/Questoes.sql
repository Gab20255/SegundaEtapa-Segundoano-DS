use Paises2025;
--Questão 3
--1
SELECT continente, count(*) as ' Quantidade de Países'
from PaisesContinenteCodigo
GROUP BY continente
HAVING 20<count (*) 
--2