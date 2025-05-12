use Paises2025;
--Questão 3
--1
SELECT continente, count(*) as ' Quantidade de Países'
from PaisesContinenteCodigo
GROUP BY continente
HAVING 20<count (*) 
--2
select p.nome_pais, d.pib_per_capita_usd
from PaisesContinenteCodigo p 
join DadosPaises2 d on d.codigo_pais= p.codigo_pais
ORDER BY d.pib_per_capita_usd desc
limit 10
--3
select p.continente, avg(d.idh)
from PaisesContinenteCodigo p 
join DadosPaises2 d on d.codigo_pais= p.codigo_pais
where d.idh is not NULL
GROUP BY p.continente
--4
select p.nome_pais, d.idh, avg(d.idh)
from PaisesContinenteCodigo p 
join DadosPaises2 d on d.codigo_pais= p.codigo_pais
where d.idh<(
    SELECT avg(idh)
    from DadosPaises2
)
--Questao4
use Company2025
--1
select e.FIRST_NAME, e.LAST_NAME, j.JOB_TITLE
from employees e
join jobs j on e.JOB_ID= j.JOB_ID
where j.JOB_TITLE like '%Manager'
--2
select d.DEPARTMENT_NAME
from departments d
LEFT join employees e on e.DEPARTMENT_ID= d.DEPARTMENT_ID
where e.EMPLOYEE_ID is NULL
--3
select FIRST_NAME, LAST_NAME, SALARY
from employees e
where SALARY>(
    select avg(SALARY)
    from employees 
    where e.DEPARTMENT_ID= DEPARTMENT_ID
)