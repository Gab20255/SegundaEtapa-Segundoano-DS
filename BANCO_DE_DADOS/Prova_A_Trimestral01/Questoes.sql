use Prova1;
--Questao 3
--1
SELECT e.nome, c.Estado, count(c.Estado) as 'Quantidade de Cidades registradas'
from cidades c 
INNER JOIN estados e on e.Sigla=c.Estado
GROUP BY c.Estado
HAVING count (c.Estado) >5
--2
select c.Estado, sum(pc.Populacao)
from cidades c 
INNER JOIN PopulacaoCidades pc on pc.CidadeID=c.ID
GROUP BY c.Estado
HAVING  (pc.Populacao) >5000000
--3
select c.Nome, c.Estado, pc.Populacao
from cidades c 
JOIN PopulacaoCidades pc  on pc.CidadeID=c.ID
where pc.Populacao=(
    select MAX(pc2.Populacao)
    from PopulacaoCidades pc2
    JOIN cidades c2 on c2.ID= pc2.CidadeID
    where c2.Estado=c.Estado
)
--4
select c.nome, pc.Populacao
from cidades c 
INNER JOIN PopulacaoCidades pc on pc.CidadeID=c.ID
where 100000<pc.Populacao<500000
ORDER BY  c.nome asc,  pc.Populacao desc;
--5
SELECT e.Nome, pe.Populacao
from estados e 
JOIN PopulacaoEstados pe on pe.EstadoSigla= e.Sigla
where pe.Populacao>10000000 
