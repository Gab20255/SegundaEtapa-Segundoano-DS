-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Jun 16, 2025 at 12:38 PM
-- Server version: 8.0.41
-- PHP Version: 8.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Academia`
--

-- --------------------------------------------------------

--
-- Table structure for table `Aluno`
--

CREATE TABLE `Aluno` (
  `id_aluno` int NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `nascimento` date DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `id_instrutor` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Aluno`
--

INSERT INTO `Aluno` (`id_aluno`, `nome`, `cpf`, `nascimento`, `telefone`, `id_instrutor`) VALUES
(1, 'Ana Souza', '123.456.789-00', '1998-05-20', '31999998888', 1),
(2, 'Bruno Lima', '987.654.321-00', '1995-12-10', '31999997777', 2),
(3, 'Camila Torres', '111.222.333-44', '2000-03-15', '31999996666', 1),
(4, 'Daniel Costa', '555.666.777-88', '1990-08-30', '31999995555', 3);

-- --------------------------------------------------------

--
-- Table structure for table `Exercicio`
--

CREATE TABLE `Exercicio` (
  `id_exercicio` int NOT NULL,
  `nome` varchar(100) NOT NULL,
  `grupo_muscular` varchar(50) DEFAULT NULL,
  `descricao` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Exercicio`
--

INSERT INTO `Exercicio` (`id_exercicio`, `nome`, `grupo_muscular`, `descricao`) VALUES
(1, 'Supino Reto', 'Peito', 'Execução em banco com barra para desenvolver peitoral maior'),
(2, 'Agachamento Livre', 'Pernas', 'Agachamento com barra livre, foco em quadríceps e glúteos'),
(3, 'Puxada Frontal', 'Costas', 'Puxada na polia alta para dorsais'),
(4, 'Desenvolvimento com Halteres', 'Ombros', 'Elevação dos halteres acima da cabeça'),
(5, 'Rosca Direta', 'Bíceps', 'Flexão dos cotovelos com barra ou halteres'),
(6, 'Tríceps Testa', 'Tríceps', 'Extensão de cotovelos com barra deitado');

-- --------------------------------------------------------

--
-- Table structure for table `FichaTreino`
--

CREATE TABLE `FichaTreino` (
  `id_ficha` int NOT NULL,
  `id_aluno` int NOT NULL,
  `id_instrutor` int NOT NULL,
  `data_criacao` date NOT NULL,
  `objetivo` varchar(100) DEFAULT NULL,
  `observacoes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `FichaTreino`
--

INSERT INTO `FichaTreino` (`id_ficha`, `id_aluno`, `id_instrutor`, `data_criacao`, `objetivo`, `observacoes`) VALUES
(1, 1, 1, '2025-06-16', 'Hipertrofia', 'Foco em membros superiores'),
(2, 2, 2, '2025-06-16', 'Emagrecimento', 'Circuito com pouco tempo de descanso'),
(3, 3, 1, '2025-06-16', 'Resistência', 'Treino leve com mais repetições'),
(4, 4, 3, '2025-06-16', 'Força', 'Alta carga, baixo volume');

-- --------------------------------------------------------

--
-- Table structure for table `Instrutor`
--

CREATE TABLE `Instrutor` (
  `id_instrutor` int NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cref` varchar(20) NOT NULL,
  `especialidade` varchar(100) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Instrutor`
--

INSERT INTO `Instrutor` (`id_instrutor`, `nome`, `cref`, `especialidade`, `telefone`) VALUES
(1, 'Carlos Andrade', '123456-G/MG', 'Musculação', '31988884444'),
(2, 'Juliana Silva', '654321-G/MG', 'Funcional', '31977775555'),
(3, 'Marcos Pereira', '987654-G/MG', 'Treinamento de força', '31966663333');

-- --------------------------------------------------------

--
-- Table structure for table `ItemFicha`
--

CREATE TABLE `ItemFicha` (
  `id_item` int NOT NULL,
  `id_ficha` int NOT NULL,
  `id_exercicio` int NOT NULL,
  `series` int DEFAULT NULL,
  `repeticoes` int DEFAULT NULL,
  `carga_kg` decimal(5,2) DEFAULT NULL,
  `tempo_descanso_seg` int DEFAULT NULL,
  `observacoes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ItemFicha`
--

INSERT INTO `ItemFicha` (`id_item`, `id_ficha`, `id_exercicio`, `series`, `repeticoes`, `carga_kg`, `tempo_descanso_seg`, `observacoes`) VALUES
(1, 1, 1, 4, 10, 60.00, 90, 'Execução lenta'),
(2, 1, 4, 4, 12, 14.00, 60, 'Controlar respiração'),
(3, 1, 5, 3, 15, 12.50, 45, NULL),
(4, 2, 2, 3, 15, 40.00, 30, 'Pausa curta'),
(5, 2, 3, 3, 12, 30.00, 30, NULL),
(6, 2, 6, 3, 15, 15.00, 30, 'Alongar após'),
(7, 3, 4, 4, 20, 10.00, 60, 'Foco no tempo de execução'),
(8, 3, 5, 4, 20, 10.00, 45, NULL),
(9, 4, 2, 5, 5, 90.00, 120, 'Aquecimento antes'),
(10, 4, 1, 5, 5, 80.00, 120, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Aluno`
--
ALTER TABLE `Aluno`
  ADD PRIMARY KEY (`id_aluno`),
  ADD UNIQUE KEY `cpf` (`cpf`),
  ADD KEY `id_instrutor` (`id_instrutor`);

--
-- Indexes for table `Exercicio`
--
ALTER TABLE `Exercicio`
  ADD PRIMARY KEY (`id_exercicio`);

--
-- Indexes for table `FichaTreino`
--
ALTER TABLE `FichaTreino`
  ADD PRIMARY KEY (`id_ficha`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_instrutor` (`id_instrutor`);

--
-- Indexes for table `Instrutor`
--
ALTER TABLE `Instrutor`
  ADD PRIMARY KEY (`id_instrutor`),
  ADD UNIQUE KEY `cref` (`cref`);

--
-- Indexes for table `ItemFicha`
--
ALTER TABLE `ItemFicha`
  ADD PRIMARY KEY (`id_item`),
  ADD KEY `id_ficha` (`id_ficha`),
  ADD KEY `id_exercicio` (`id_exercicio`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Aluno`
--
ALTER TABLE `Aluno`
  MODIFY `id_aluno` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Exercicio`
--
ALTER TABLE `Exercicio`
  MODIFY `id_exercicio` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `FichaTreino`
--
ALTER TABLE `FichaTreino`
  MODIFY `id_ficha` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Instrutor`
--
ALTER TABLE `Instrutor`
  MODIFY `id_instrutor` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `ItemFicha`
--
ALTER TABLE `ItemFicha`
  MODIFY `id_item` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Aluno`
--
ALTER TABLE `Aluno`
  ADD CONSTRAINT `Aluno_ibfk_1` FOREIGN KEY (`id_instrutor`) REFERENCES `Instrutor` (`id_instrutor`);

--
-- Constraints for table `FichaTreino`
--
ALTER TABLE `FichaTreino`
  ADD CONSTRAINT `FichaTreino_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `Aluno` (`id_aluno`),
  ADD CONSTRAINT `FichaTreino_ibfk_2` FOREIGN KEY (`id_instrutor`) REFERENCES `Instrutor` (`id_instrutor`);

--
-- Constraints for table `ItemFicha`
--
ALTER TABLE `ItemFicha`
  ADD CONSTRAINT `ItemFicha_ibfk_1` FOREIGN KEY (`id_ficha`) REFERENCES `FichaTreino` (`id_ficha`),
  ADD CONSTRAINT `ItemFicha_ibfk_2` FOREIGN KEY (`id_exercicio`) REFERENCES `Exercicio` (`id_exercicio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
