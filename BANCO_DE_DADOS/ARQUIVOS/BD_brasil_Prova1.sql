-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 03, 2025 at 09:29 PM
-- Server version: 8.0.41-0ubuntu0.22.04.1
-- PHP Version: 8.3.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `brasil`
--

-- --------------------------------------------------------

--
-- Table structure for table `cidades`
--
CREATE Database IF NOT EXISTS Prova1;
use Prova1;
CREATE TABLE `cidades` (
  `ID` int NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cidades`
--

INSERT INTO `cidades` (`ID`, `Nome`, `Estado`) VALUES
(1, 'Rio Branco', 'AC'),
(2, 'Cruzeiro do Sul', 'AC'),
(3, 'Sena Madureira', 'AC'),
(4, 'Tarauacá', 'AC'),
(5, 'Feijó', 'AC'),
(6, 'Maceió', 'AL'),
(7, 'Arapiraca', 'AL'),
(8, 'Rio Largo', 'AL'),
(9, 'Palmeira dos Índios', 'AL'),
(10, 'União dos Palmares', 'AL'),
(11, 'Macapá', 'AP'),
(12, 'Santana', 'AP'),
(13, 'Laranjal do Jari', 'AP'),
(14, 'Oiapoque', 'AP'),
(15, 'Porto Grande', 'AP'),
(16, 'Manaus', 'AM'),
(17, 'Parintins', 'AM'),
(18, 'Itacoatiara', 'AM'),
(19, 'Manacapuru', 'AM'),
(20, 'Coari', 'AM'),
(21, 'Salvador', 'BA'),
(22, 'Feira de Santana', 'BA'),
(23, 'Vitória da Conquista', 'BA'),
(24, 'Camaçari', 'BA'),
(25, 'Itabuna', 'BA'),
(26, 'Juazeiro', 'BA'),
(27, 'Lauro de Freitas', 'BA'),
(28, 'Fortaleza', 'CE'),
(29, 'Caucaia', 'CE'),
(30, 'Juazeiro do Norte', 'CE'),
(31, 'Maracanaú', 'CE'),
(32, 'Sobral', 'CE'),
(33, 'Brasília', 'DF'),
(34, 'Vitória', 'ES'),
(35, 'Vila Velha', 'ES'),
(36, 'Serra', 'ES'),
(37, 'Cariacica', 'ES'),
(38, 'Linhares', 'ES'),
(39, 'Goiânia', 'GO'),
(40, 'Aparecida de Goiânia', 'GO'),
(41, 'Anápolis', 'GO'),
(42, 'Rio Verde', 'GO'),
(43, 'Luziânia', 'GO'),
(44, 'São Luís', 'MA'),
(45, 'Imperatriz', 'MA'),
(46, 'São José de Ribamar', 'MA'),
(47, 'Timon', 'MA'),
(48, 'Caxias', 'MA'),
(49, 'Cuiabá', 'MT'),
(50, 'Várzea Grande', 'MT'),
(51, 'Rondonópolis', 'MT'),
(52, 'Sinop', 'MT'),
(53, 'Tangará da Serra', 'MT'),
(54, 'Campo Grande', 'MS'),
(55, 'Dourados', 'MS'),
(56, 'Três Lagoas', 'MS'),
(57, 'Corumbá', 'MS'),
(58, 'Ponta Porã', 'MS'),
(59, 'Belo Horizonte', 'MG'),
(60, 'Uberlândia', 'MG'),
(61, 'Contagem', 'MG'),
(62, 'Juiz de Fora', 'MG'),
(63, 'Betim', 'MG'),
(64, 'Montes Claros', 'MG'),
(65, 'Ribeirão das Neves', 'MG'),
(66, 'Belém', 'PA'),
(67, 'Ananindeua', 'PA'),
(68, 'Santarém', 'PA'),
(69, 'Marabá', 'PA'),
(70, 'Castanhal', 'PA'),
(71, 'João Pessoa', 'PB'),
(72, 'Campina Grande', 'PB'),
(73, 'Santa Rita', 'PB'),
(74, 'Patos', 'PB'),
(75, 'Bayeux', 'PB'),
(76, 'Curitiba', 'PR'),
(77, 'Londrina', 'PR'),
(78, 'Maringá', 'PR'),
(79, 'Ponta Grossa', 'PR'),
(80, 'Cascavel', 'PR'),
(81, 'São José dos Pinhais', 'PR'),
(82, 'Recife', 'PE'),
(83, 'Jaboatão dos Guararapes', 'PE'),
(84, 'Olinda', 'PE'),
(85, 'Caruaru', 'PE'),
(86, 'Petrolina', 'PE'),
(87, 'Paulista', 'PE'),
(88, 'Teresina', 'PI'),
(89, 'Parnaíba', 'PI'),
(90, 'Picos', 'PI'),
(91, 'Piripiri', 'PI'),
(92, 'Floriano', 'PI'),
(93, 'Rio de Janeiro', 'RJ'),
(94, 'São Gonçalo', 'RJ'),
(95, 'Duque de Caxias', 'RJ'),
(96, 'Nova Iguaçu', 'RJ'),
(97, 'Niterói', 'RJ'),
(98, 'Belford Roxo', 'RJ'),
(99, 'São João de Meriti', 'RJ'),
(100, 'Natal', 'RN'),
(101, 'Mossoró', 'RN'),
(102, 'Parnamirim', 'RN'),
(103, 'São Gonçalo do Amarante', 'RN'),
(104, 'Macaíba', 'RN'),
(105, 'Porto Alegre', 'RS'),
(106, 'Caxias do Sul', 'RS'),
(107, 'Pelotas', 'RS'),
(108, 'Canoas', 'RS'),
(109, 'Santa Maria', 'RS'),
(110, 'Gravataí', 'RS'),
(111, 'Viamão', 'RS'),
(112, 'Porto Velho', 'RO'),
(113, 'Ji-Paraná', 'RO'),
(114, 'Ariquemes', 'RO'),
(115, 'Vilhena', 'RO'),
(116, 'Cacoal', 'RO'),
(117, 'Boa Vista', 'RR'),
(118, 'Rorainópolis', 'RR'),
(119, 'Caracaraí', 'RR'),
(120, 'Alto Alegre', 'RR'),
(121, 'Bonfim', 'RR'),
(122, 'Florianópolis', 'SC'),
(123, 'Joinville', 'SC'),
(124, 'Blumenau', 'SC'),
(125, 'São José', 'SC'),
(126, 'Chapecó', 'SC'),
(127, 'Itajaí', 'SC'),
(128, 'Criciúma', 'SC'),
(129, 'São Paulo', 'SP'),
(130, 'Guarulhos', 'SP'),
(131, 'Campinas', 'SP'),
(132, 'São Bernardo do Campo', 'SP'),
(133, 'Santo André', 'SP'),
(134, 'Osasco', 'SP'),
(135, 'São José dos Campos', 'SP'),
(136, 'Ribeirão Preto', 'SP'),
(137, 'Sorocaba', 'SP'),
(138, 'Aracaju', 'SE'),
(139, 'Nossa Senhora do Socorro', 'SE'),
(140, 'Lagarto', 'SE'),
(141, 'Itabaiana', 'SE'),
(142, 'São Cristóvão', 'SE'),
(143, 'Palmas', 'TO'),
(144, 'Araguaína', 'TO'),
(145, 'Gurupi', 'TO'),
(146, 'Porto Nacional', 'TO'),
(147, 'Paraíso do Tocantins', 'TO');

-- --------------------------------------------------------

--
-- Table structure for table `estados`
--

CREATE TABLE `estados` (
  `ID` int NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Sigla` varchar(2) NOT NULL,
  `Capital` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `estados`
--

INSERT INTO `estados` (`ID`, `Nome`, `Sigla`, `Capital`) VALUES
(1, 'Acre', 'AC', 1),
(2, 'Alagoas', 'AL', 6),
(3, 'Amapá', 'AP', 11),
(4, 'Amazonas', 'AM', 16),
(5, 'Bahia', 'BA', 21),
(6, 'Ceará', 'CE', 28),
(7, 'Distrito Federal', 'DF', 33),
(8, 'Espírito Santo', 'ES', 34),
(9, 'Goiás', 'GO', 39),
(10, 'Maranhão', 'MA', 44),
(11, 'Mato Grosso', 'MT', 49),
(12, 'Mato Grosso do Sul', 'MS', 54),
(13, 'Minas Gerais', 'MG', 59),
(14, 'Pará', 'PA', 66),
(15, 'Paraíba', 'PB', 71),
(16, 'Paraná', 'PR', 76),
(17, 'Pernambuco', 'PE', 82),
(18, 'Piauí', 'PI', 88),
(19, 'Rio de Janeiro', 'RJ', 93),
(20, 'Rio Grande do Norte', 'RN', 100),
(21, 'Rio Grande do Sul', 'RS', 105),
(22, 'Rondônia', 'RO', 112),
(23, 'Roraima', 'RR', 117),
(24, 'Santa Catarina', 'SC', 122),
(25, 'São Paulo', 'SP', 129),
(26, 'Sergipe', 'SE', 138),
(27, 'Tocantins', 'TO', 143);

-- --------------------------------------------------------

--
-- Table structure for table `PopulacaoCidades`
--

CREATE TABLE `PopulacaoCidades` (
  `CidadeID` int NOT NULL,
  `Populacao` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `PopulacaoCidades`
--

INSERT INTO `PopulacaoCidades` (`CidadeID`, `Populacao`) VALUES
(1, 413418),
(2, 88376),
(3, 46257),
(4, 39935),
(5, 35522),
(6, 1025360),
(7, 234185),
(8, 75750),
(9, 73296),
(10, 68836),
(11, 512902),
(12, 123096),
(13, 50979),
(14, 28315),
(15, 21331),
(16, 2219580),
(17, 115363),
(18, 102701),
(19, 100548),
(20, 85772),
(21, 2886698),
(22, 624107),
(23, 343230),
(24, 304302),
(25, 219680),
(26, 218162),
(27, 197636),
(28, 2686612),
(29, 365212),
(30, 274207),
(31, 229458),
(32, 210711),
(33, 3094325),
(34, 369534),
(35, 501325),
(36, 527240),
(37, 383917),
(38, 176688),
(39, 1555626),
(40, 578179),
(41, 391772),
(42, 241518),
(43, 211508),
(44, 1101884),
(45, 259980),
(46, 179373),
(47, 171317),
(48, 167424),
(49, 623614),
(50, 299472),
(51, 236042),
(52, 146005),
(53, 103726),
(54, 906092),
(55, 225495),
(56, 123281),
(57, 112058),
(58, 92865),
(59, 2523794),
(60, 699097),
(61, 668949),
(62, 573285),
(63, 444784),
(64, 413487),
(65, 338197),
(66, 1499641),
(67, 540410),
(68, 306480),
(69, 283542),
(70, 203251),
(71, 817511),
(72, 411807),
(73, 135819),
(74, 108192),
(75, 102860),
(76, 1963726),
(77, 575377),
(78, 436472),
(79, 355336),
(80, 332333),
(81, 329058),
(82, 1653461),
(83, 706867),
(84, 393115),
(85, 365278),
(86, 359372),
(87, 334742),
(88, 868075),
(89, 153482),
(90, 78392),
(91, 64331),
(92, 60222),
(93, 6747815),
(94, 1098357),
(95, 924624),
(96, 818875),
(97, 515317),
(98, 513118),
(99, 480920),
(100, 890480),
(101, 303792),
(102, 267036),
(103, 103796),
(104, 80718),
(105, 1492530),
(106, 517451),
(107, 343132),
(108, 347657),
(109, 283677),
(110, 283620),
(111, 256302),
(112, 548952),
(113, 130009),
(114, 109523),
(115, 102211),
(116, 87729),
(117, 436591),
(118, 31394),
(119, 23148),
(120, 17139),
(121, 12555),
(122, 516524),
(123, 597658),
(124, 361855),
(125, 250181),
(126, 224302),
(127, 223112),
(128, 213023),
(129, 12396372),
(130, 1404694),
(131, 1223773),
(132, 849874),
(133, 723889),
(134, 699944),
(135, 729737),
(136, 720216),
(137, 687357),
(138, 664908),
(139, 185706),
(140, 104788),
(141, 95814),
(142, 89670),
(143, 306296),
(144, 177787),
(145, 87105),
(146, 53900),
(147, 51842);

-- --------------------------------------------------------

--
-- Table structure for table `PopulacaoEstados`
--

CREATE TABLE `PopulacaoEstados` (
  `EstadoSigla` varchar(2) NOT NULL,
  `Populacao` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `PopulacaoEstados`
--

INSERT INTO `PopulacaoEstados` (`EstadoSigla`, `Populacao`) VALUES
('AC', 906876),
('AL', 3365351),
('AM', 4269995),
('AP', 877613),
('BA', 14985284),
('CE', 9240580),
('DF', 3094325),
('ES', 4108508),
('GO', 7206589),
('MA', 7153262),
('MG', 21411923),
('MS', 2839188),
('MT', 3567234),
('PA', 8777124),
('PB', 4059905),
('PE', 9674793),
('PI', 3289290),
('PR', 11516840),
('RJ', 17463349),
('RN', 3560903),
('RO', 1815278),
('RR', 652713),
('RS', 11466630),
('SC', 7338473),
('SE', 2338474),
('SP', 46649132),
('TO', 1607363);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cidades`
--
ALTER TABLE `cidades`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Estado` (`Estado`);

--
-- Indexes for table `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Sigla` (`Sigla`);

--
-- Indexes for table `PopulacaoCidades`
--
ALTER TABLE `PopulacaoCidades`
  ADD PRIMARY KEY (`CidadeID`);

--
-- Indexes for table `PopulacaoEstados`
--
ALTER TABLE `PopulacaoEstados`
  ADD PRIMARY KEY (`EstadoSigla`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cidades`
--
ALTER TABLE `cidades`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=148;

--
-- AUTO_INCREMENT for table `estados`
--
ALTER TABLE `estados`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cidades`
--
ALTER TABLE `cidades`
  ADD CONSTRAINT `cidades_ibfk_1` FOREIGN KEY (`Estado`) REFERENCES `estados` (`Sigla`);

--
-- Constraints for table `PopulacaoCidades`
--
ALTER TABLE `PopulacaoCidades`
  ADD CONSTRAINT `PopulacaoCidades_ibfk_1` FOREIGN KEY (`CidadeID`) REFERENCES `cidades` (`ID`);

--
-- Constraints for table `PopulacaoEstados`
--
ALTER TABLE `PopulacaoEstados`
  ADD CONSTRAINT `PopulacaoEstados_ibfk_1` FOREIGN KEY (`EstadoSigla`) REFERENCES `estados` (`Sigla`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
