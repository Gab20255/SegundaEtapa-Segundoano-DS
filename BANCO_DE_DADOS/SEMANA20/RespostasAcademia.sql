--1. Liste todos os alunos da academia, mostrando o nome e a data de nascimento, em ordem alfabética.
SELECT nome, nascimento FROM Aluno ORDER BY nome;

--2. Exiba o nome dos exercícios que trabalham o grupo muscular “Peito”.
SELECT nome FROM Exercicio WHERE grupo_muscular = 'Peito';

--3. Mostre o nome dos instrutores e quantos alunos estão sob responsabilidade de cada um.
SELECT I.nome, COUNT(A.id) AS total_alunos
FROM Instrutor I
LEFT JOIN Aluno A ON I.id = A.id_instrutor
GROUP BY I.nome;

--4. Liste os nomes dos alunos e o nome do instrutor responsável por eles.
SELECT A.nome AS aluno, I.nome AS instrutor
FROM Aluno A
JOIN Instrutor I ON A.id_instrutor = I.id;


--5. Para cada ficha de treino cadastrada, exiba o nome do aluno, o objetivo da ficha e a data de criação.
SELECT A.nome AS aluno, F.objetivo, F.data_criacao
FROM FichaTreino F
JOIN Aluno A ON F.id_aluno = A.id;


--6. Mostre todos os itens da ficha de treino do aluno “Ana Souza”, incluindo o nome do exercício, número de séries, repetições e carga usada.
SELECT E.nome AS exercicio, I.series, I.repeticoes, I.carga_kg
FROM ItemFicha I
JOIN Exercicio E ON I.id_exercicio = E.id
JOIN FichaTreino F ON I.id_ficha = F.id
JOIN Aluno A ON F.id_aluno = A.id
WHERE A.nome = 'Ana Souza';


--7. Liste os alunos que possuem ficha de treino com o objetivo “Emagrecimento”.
SELECT A.nome
FROM FichaTreino F
JOIN Aluno A ON F.id_aluno = A.id
WHERE F.objetivo = 'Emagrecimento';


--8. Exiba o nome de todos os exercícios usados nas fichas que possuem tempo de descanso menor ou igual a 45 segundos.
SELECT DISTINCT E.nome
FROM ItemFicha I
JOIN Exercicio E ON I.id_exercicio = E.id
WHERE I.tempo_descanso_seg <= 45;


--9. Mostre a quantidade total de exercícios cadastrados no sistema.
SELECT COUNT(*) AS total_exercicios FROM Exercicio;


--10. Liste todos os instrutores que ainda não têm nenhum aluno atribuído a eles.
SELECT I.nome
FROM Instrutor I
LEFT JOIN Aluno A ON I.

