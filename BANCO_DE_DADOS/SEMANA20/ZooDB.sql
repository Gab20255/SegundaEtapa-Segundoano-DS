CREATE DATABASE IF NOT EXISTS ZOO;

CREATE TABLE Pessoa (
    CPF VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(50),
    idade INT,
    telefone BIGINT
);

CREATE TABLE Visitante (
    CPF VARCHAR(11),
    preferencia VARCHAR(50),
    PRIMARY KEY (CPF),
    FOREIGN KEY (CPF) REFERENCES Pessoa(CPF)
);

CREATE TABLE Funcionario (
    CPF VARCHAR(11),
    funcao VARCHAR(50),
    formacao VARCHAR(50),
    dias_de_contrato VARCHAR(50),
    PRIMARY KEY (CPF),
    FOREIGN KEY (CPF) REFERENCES Pessoa(CPF)
);

CREATE TABLE Animal (
    idAnimal INT PRIMARY KEY,
    nome VARCHAR(50),
    temperamento VARCHAR(30),
    requisito_de_formacao VARCHAR(50),
    Funcionario_CPF VARCHAR(11),
    FOREIGN KEY (Funcionario_CPF) REFERENCES Funcionario(CPF)
);

CREATE TABLE Jaula (
    idJaula INT PRIMARY KEY,
    Animal_idAnimal INT,
    localizacao VARCHAR(50),
    FOREIGN KEY (Animal_idAnimal) REFERENCES Animal(idAnimal)
);

CREATE TABLE Ingresso (
    idIngresso INT PRIMARY KEY,
    Visitante_CPF VARCHAR(11),
    FOREIGN KEY (Visitante_CPF) REFERENCES Visitante(CPF)
);

-- INSERÇÃO DE DADOS

INSERT INTO Pessoa (CPF, nome, idade, telefone) VALUES
('11111111111', 'João Silva', 35, 11987654321),
('22222222222', 'Maria Souza', 28, 11912345678),
('33333333333', 'Carlos Pereira', 42, 21999998888),
('44444444444', 'Ana Lima', 30, 21987654321),
('55555555555', 'Felipe Rocha', 50, 11988887777),
('66666666666', 'Luciana Alves', 26, 11933334444),
('77777777777', 'Ricardo Mendes', 38, 11944445555),
('88888888888', 'Patrícia Moraes', 31, 21911112222),
('99999999999', 'Thiago Costa', 24, 21933335555),
('10101010101', 'Sabrina Teixeira', 29, 21966667777),
('12121212121', 'Eduardo Ramos', 40, 11977778888),
('13131313131', 'Vanessa Dias', 27, 11999996666),
('14141414141', 'Diego Martins', 36, 21955554444),
('15151515151', 'Beatriz Pires', 23, 21988889999),
('16161616161', 'Gustavo Nogueira', 32, 11922221111),
('17171717171', 'Fernanda Lopes', 41, 21900001111),
('18181818181', 'Pedro Almeida', 33, 11911113333),
('19191919191', 'Juliana Rocha', 37, 11988886666),
('20202020202', 'Bruno Ferreira', 39, 21944443333),
('21212121212', 'Camila Barbosa', 25, 21922220000);

INSERT INTO Visitante (CPF, preferencia) VALUES
('11111111111', 'Safari'),
('22222222222', 'Fotografia'),
('44444444444', 'Educação Infantil'),
('66666666666', 'Safari'),
('88888888888', 'Alimentação'),
('10101010101', 'Passeio Noturno'),
('13131313131', 'Interação com Animais'),
('15151515151', 'Shows'),
('17171717171', 'Fotografia'),
('19191919191', 'Shows');

INSERT INTO Funcionario (CPF, funcao, formacao, dias_de_contrato) VALUES
('33333333333', 'Veterinário', 'Medicina Veterinária', 'Seg–Sex'),
('55555555555', 'Tratador', 'Zootecnia', 'Seg–Sab'),
('77777777777', 'Biólogo', 'Biologia', 'Seg–Sex'),
('99999999999', 'Guia', 'Turismo', 'Qua–Dom'),
('12121212121', 'Alimentador', 'Agronomia', 'Seg–Sex'),
('14141414141', 'Veterinário', 'Medicina Veterinária', 'Seg–Sex'),
('16161616161', 'Administrador', 'Administração', 'Seg–Sex'),
('18181818181', 'Biólogo', 'Biologia', 'Seg–Sex'),
('20202020202', 'Segurança', 'Ensino Médio', 'Seg–Dom'),
('21212121212', 'Zelador', 'Ensino Médio', 'Seg–Sab');

INSERT INTO Animal (idAnimal, nome, temperamento, requisito_de_formacao, Funcionario_CPF) VALUES
(1, 'Leão', 'Agressivo', 'Medicina Veterinária', '33333333333'),
(2, 'Elefante', 'Calmo', 'Zootecnia', '55555555555'),
(3, 'Macaco', 'Agitado', 'Biologia', '77777777777'),
(4, 'Girafa', 'Calmo', 'Biologia', '18181818181'),
(5, 'Tigre', 'Agressivo', 'Medicina Veterinária', '14141414141'),
(6, 'Hipopótamo', 'Agressivo', 'Zootecnia', '55555555555'),
(7, 'Onça', 'Agitado', 'Biologia', '18181818181'),
(8, 'Urso', 'Calmo', 'Biologia', '77777777777'),
(9, 'Lobo', 'Agitado', 'Turismo', '99999999999'),
(10, 'Pinguim', 'Calmo', 'Biologia', '77777777777');

INSERT INTO Jaula (idJaula, Animal_idAnimal, localizacao) VALUES
(1, 1, 'Setor A1'),
(2, 2, 'Setor A2'),
(3, 3, 'Setor B1'),
(4, 4, 'Setor B2'),
(5, 5, 'Setor A3'),
(6, 6, 'Setor C1'),
(7, 7, 'Setor C2'),
(8, 8, 'Setor D1'),
(9, 9, 'Setor D2'),
(10, 10, 'Setor E1');

INSERT INTO Ingresso (idIngresso, Visitante_CPF) VALUES
(1, '11111111111'),
(2, '22222222222'),
(3, '44444444444'),
(4, '66666666666'),
(5, '88888888888'),
(6, '10101010101'),
(7, '13131313131'),
(8, '15151515151'),
(9, '17171717171'),
(10, '19191919191');