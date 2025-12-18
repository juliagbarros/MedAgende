
-- Banco de dados: `medagende(real)`
-- Autor do script: Lucas Leandro


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bancodedadosmedagende`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `agenda`
--

CREATE TABLE `agenda` (
  `matricula_medico` int(11) NOT NULL,
  `dia` date NOT NULL,
  `hora_entrada` time NOT NULL,
  `hora_saida` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `agenda`
--

INSERT INTO `agenda` (`matricula_medico`, `dia`, `hora_entrada`, `hora_saida`) VALUES
(4, '2025-02-13', '13:00:00', '23:00:00'),
(4, '2025-02-14', '14:00:00', '00:00:00'),
(4, '2025-02-15', '15:00:00', '01:00:00'),
(4, '2025-02-16', '16:00:00', '02:00:00'),
(4, '2025-02-17', '17:00:00', '03:00:00'),
(4, '2025-02-18', '18:00:00', '04:00:00'),
(4, '2025-02-19', '19:00:00', '05:00:00'),
(4, '2025-02-20', '20:00:00', '06:00:00'),
(4, '2025-02-21', '21:00:00', '07:00:00'),
(4, '2025-02-22', '22:00:00', '08:00:00'),
(4, '2025-02-23', '23:00:00', '09:00:00'),
(4, '2025-02-24', '00:00:00', '10:00:00'),
(4, '2025-02-25', '01:00:00', '11:00:00'),
(4, '2025-02-26', '02:00:00', '12:00:00'),
(4, '2025-02-27', '03:00:00', '13:00:00'),
(4, '2025-02-28', '04:00:00', '14:00:00'),
(4, '2025-03-01', '05:00:00', '15:00:00'),
(4, '2025-03-02', '06:00:00', '16:00:00'),
(4, '2025-03-03', '07:00:00', '17:00:00'),
(4, '2025-03-04', '08:00:00', '18:00:00'),
(4, '2025-03-05', '09:00:00', '19:00:00'),
(4, '2025-03-06', '10:00:00', '20:00:00'),
(4, '2025-03-07', '11:00:00', '21:00:00'),
(4, '2025-03-08', '12:00:00', '22:00:00'),
(4, '2025-03-09', '13:00:00', '23:00:00'),
(4, '2025-03-10', '14:00:00', '00:00:00'),
(4, '2025-03-11', '15:00:00', '01:00:00'),
(4, '2025-03-12', '16:00:00', '02:00:00'),
(4, '2025-03-13', '17:00:00', '03:00:00'),
(4, '2025-03-14', '18:00:00', '04:00:00'),
(4, '2025-03-15', '19:00:00', '05:00:00'),
(4, '2025-03-16', '20:00:00', '06:00:00'),
(4, '2025-03-17', '21:00:00', '07:00:00'),
(4, '2025-03-18', '22:00:00', '08:00:00'),
(4, '2025-03-19', '23:00:00', '09:00:00'),
(4, '2025-03-20', '00:00:00', '10:00:00'),
(4, '2025-03-21', '01:00:00', '11:00:00'),
(4, '2025-03-22', '02:00:00', '12:00:00'),
(4, '2025-03-23', '03:00:00', '13:00:00'),
(4, '2025-03-24', '04:00:00', '14:00:00'),
(4, '2025-03-25', '05:00:00', '15:00:00'),
(4, '2025-03-26', '06:00:00', '16:00:00'),
(4, '2025-03-27', '07:00:00', '17:00:00'),
(4, '2025-03-28', '08:00:00', '18:00:00'),
(4, '2025-03-29', '09:00:00', '19:00:00'),
(4, '2025-03-30', '10:00:00', '20:00:00'),
(4, '2025-03-31', '11:00:00', '21:00:00'),
(4, '2025-04-01', '12:00:00', '22:00:00'),
(4, '2025-04-02', '13:00:00', '23:00:00'),
(4, '2025-04-03', '14:00:00', '00:00:00'),
(4, '2025-04-04', '15:00:00', '01:00:00'),
(4, '2025-04-05', '16:00:00', '02:00:00'),
(4, '2025-04-06', '17:00:00', '03:00:00'),
(4, '2025-04-07', '18:00:00', '04:00:00'),
(4, '2025-04-08', '19:00:00', '05:00:00'),
(4, '2025-04-09', '20:00:00', '06:00:00'),
(4, '2025-04-10', '21:00:00', '07:00:00'),
(4, '2025-04-11', '22:00:00', '08:00:00'),
(4, '2025-04-12', '23:00:00', '09:00:00'),
(4, '2025-04-13', '00:00:00', '10:00:00'),
(4, '2025-04-14', '01:00:00', '11:00:00'),
(4, '2025-04-15', '02:00:00', '12:00:00'),
(4, '2025-04-16', '03:00:00', '13:00:00'),
(4, '2025-04-17', '04:00:00', '14:00:00'),
(4, '2025-04-18', '05:00:00', '15:00:00'),
(4, '2025-04-19', '06:00:00', '16:00:00'),
(4, '2025-04-20', '07:00:00', '17:00:00'),
(4, '2025-04-21', '08:00:00', '18:00:00'),
(4, '2025-04-22', '09:00:00', '19:00:00'),
(4, '2025-04-23', '10:00:00', '20:00:00'),
(5, '2025-02-13', '13:00:00', '23:00:00'),
(5, '2025-02-14', '13:00:00', '23:00:00'),
(5, '2025-02-15', '13:00:00', '23:00:00'),
(5, '2025-02-16', '13:00:00', '23:00:00'),
(5, '2025-02-17', '13:00:00', '23:00:00'),
(5, '2025-02-18', '13:00:00', '23:00:00'),
(5, '2025-02-19', '13:00:00', '23:00:00'),
(5, '2025-02-20', '13:00:00', '23:00:00'),
(5, '2025-02-21', '13:00:00', '23:00:00'),
(5, '2025-02-22', '13:00:00', '23:00:00'),
(5, '2025-02-23', '13:00:00', '23:00:00'),
(5, '2025-02-24', '13:00:00', '23:00:00'),
(5, '2025-02-25', '13:00:00', '23:00:00'),
(5, '2025-02-26', '13:00:00', '23:00:00'),
(5, '2025-02-27', '13:00:00', '23:00:00'),
(5, '2025-02-28', '13:00:00', '23:00:00'),
(5, '2025-03-01', '13:00:00', '23:00:00'),
(5, '2025-03-02', '13:00:00', '23:00:00'),
(5, '2025-03-03', '13:00:00', '23:00:00'),
(5, '2025-03-04', '13:00:00', '23:00:00'),
(5, '2025-03-05', '13:00:00', '23:00:00'),
(5, '2025-03-06', '13:00:00', '23:00:00'),
(5, '2025-03-07', '13:00:00', '23:00:00'),
(5, '2025-03-08', '13:00:00', '23:00:00'),
(5, '2025-03-09', '13:00:00', '23:00:00'),
(5, '2025-03-10', '13:00:00', '23:00:00'),
(5, '2025-03-11', '13:00:00', '23:00:00'),
(5, '2025-03-12', '13:00:00', '23:00:00'),
(5, '2025-03-13', '13:00:00', '23:00:00'),
(5, '2025-03-14', '13:00:00', '23:00:00'),
(5, '2025-03-15', '13:00:00', '23:00:00'),
(5, '2025-03-16', '13:00:00', '23:00:00'),
(5, '2025-03-17', '13:00:00', '23:00:00'),
(5, '2025-03-18', '13:00:00', '23:00:00'),
(5, '2025-03-19', '13:00:00', '23:00:00'),
(5, '2025-03-20', '13:00:00', '23:00:00'),
(5, '2025-03-21', '13:00:00', '23:00:00'),
(5, '2025-03-22', '13:00:00', '23:00:00'),
(5, '2025-03-23', '13:00:00', '23:00:00'),
(5, '2025-03-24', '13:00:00', '23:00:00'),
(5, '2025-03-25', '13:00:00', '23:00:00'),
(5, '2025-03-26', '13:00:00', '23:00:00'),
(5, '2025-03-27', '13:00:00', '23:00:00'),
(5, '2025-03-28', '13:00:00', '23:00:00'),
(5, '2025-03-29', '13:00:00', '23:00:00'),
(5, '2025-03-30', '13:00:00', '23:00:00'),
(5, '2025-03-31', '13:00:00', '23:00:00'),
(5, '2025-04-01', '13:00:00', '23:00:00'),
(5, '2025-04-02', '13:00:00', '23:00:00'),
(5, '2025-04-03', '13:00:00', '23:00:00'),
(5, '2025-04-04', '13:00:00', '23:00:00'),
(5, '2025-04-05', '13:00:00', '23:00:00'),
(5, '2025-04-06', '13:00:00', '23:00:00'),
(5, '2025-04-07', '13:00:00', '23:00:00'),
(5, '2025-04-08', '13:00:00', '23:00:00'),
(5, '2025-04-09', '13:00:00', '23:00:00'),
(5, '2025-04-10', '13:00:00', '23:00:00'),
(5, '2025-04-11', '13:00:00', '23:00:00'),
(5, '2025-04-12', '13:00:00', '23:00:00'),
(5, '2025-04-13', '13:00:00', '23:00:00'),
(5, '2025-04-14', '13:00:00', '23:00:00'),
(5, '2025-04-15', '13:00:00', '23:00:00'),
(5, '2025-04-16', '13:00:00', '23:00:00'),
(5, '2025-04-17', '13:00:00', '23:00:00'),
(5, '2025-04-18', '13:00:00', '23:00:00'),
(5, '2025-04-19', '13:00:00', '23:00:00'),
(5, '2025-04-20', '13:00:00', '23:00:00'),
(5, '2025-04-21', '13:00:00', '23:00:00'),
(5, '2025-04-22', '13:00:00', '23:00:00'),
(5, '2025-04-23', '13:00:00', '23:00:00'),
(6, '2025-02-13', '13:00:00', '23:00:00'),
(6, '2025-02-14', '13:00:00', '23:00:00'),
(6, '2025-02-15', '13:00:00', '23:00:00'),
(6, '2025-02-16', '13:00:00', '23:00:00'),
(6, '2025-02-17', '13:00:00', '23:00:00'),
(6, '2025-02-18', '13:00:00', '23:00:00'),
(6, '2025-02-19', '13:00:00', '23:00:00'),
(6, '2025-02-20', '13:00:00', '23:00:00'),
(6, '2025-02-21', '13:00:00', '23:00:00'),
(6, '2025-02-22', '13:00:00', '23:00:00'),
(6, '2025-02-23', '13:00:00', '23:00:00'),
(6, '2025-02-24', '13:00:00', '23:00:00'),
(6, '2025-02-25', '13:00:00', '23:00:00'),
(6, '2025-02-26', '13:00:00', '23:00:00'),
(6, '2025-02-27', '13:00:00', '23:00:00'),
(6, '2025-02-28', '13:00:00', '23:00:00'),
(6, '2025-03-01', '13:00:00', '23:00:00'),
(6, '2025-03-02', '13:00:00', '23:00:00'),
(6, '2025-03-03', '13:00:00', '23:00:00'),
(6, '2025-03-04', '13:00:00', '23:00:00'),
(6, '2025-03-05', '13:00:00', '23:00:00'),
(6, '2025-03-06', '13:00:00', '23:00:00'),
(6, '2025-03-07', '13:00:00', '23:00:00'),
(6, '2025-03-08', '13:00:00', '23:00:00'),
(6, '2025-03-09', '13:00:00', '23:00:00'),
(6, '2025-03-10', '13:00:00', '23:00:00'),
(6, '2025-03-11', '13:00:00', '23:00:00'),
(6, '2025-03-12', '13:00:00', '23:00:00'),
(6, '2025-03-13', '13:00:00', '23:00:00'),
(6, '2025-03-14', '13:00:00', '23:00:00'),
(6, '2025-03-15', '13:00:00', '23:00:00'),
(6, '2025-03-16', '13:00:00', '23:00:00'),
(6, '2025-03-17', '13:00:00', '23:00:00'),
(6, '2025-03-18', '13:00:00', '23:00:00'),
(6, '2025-03-19', '13:00:00', '23:00:00'),
(6, '2025-03-20', '13:00:00', '23:00:00'),
(6, '2025-03-21', '13:00:00', '23:00:00'),
(6, '2025-03-22', '13:00:00', '23:00:00'),
(6, '2025-03-23', '13:00:00', '23:00:00'),
(6, '2025-03-24', '13:00:00', '23:00:00'),
(6, '2025-03-25', '13:00:00', '23:00:00'),
(6, '2025-03-26', '13:00:00', '23:00:00'),
(6, '2025-03-27', '13:00:00', '23:00:00'),
(6, '2025-03-28', '13:00:00', '23:00:00'),
(6, '2025-03-29', '13:00:00', '23:00:00'),
(6, '2025-03-30', '13:00:00', '23:00:00'),
(6, '2025-03-31', '13:00:00', '23:00:00'),
(6, '2025-04-01', '13:00:00', '23:00:00'),
(6, '2025-04-02', '13:00:00', '23:00:00'),
(6, '2025-04-03', '13:00:00', '23:00:00'),
(6, '2025-04-04', '13:00:00', '23:00:00'),
(6, '2025-04-05', '13:00:00', '23:00:00'),
(6, '2025-04-06', '13:00:00', '23:00:00'),
(6, '2025-04-07', '13:00:00', '23:00:00'),
(6, '2025-04-08', '13:00:00', '23:00:00'),
(6, '2025-04-09', '13:00:00', '23:00:00'),
(6, '2025-04-10', '13:00:00', '23:00:00'),
(6, '2025-04-11', '13:00:00', '23:00:00'),
(6, '2025-04-12', '13:00:00', '23:00:00'),
(6, '2025-04-13', '13:00:00', '23:00:00'),
(6, '2025-04-14', '13:00:00', '23:00:00'),
(6, '2025-04-15', '13:00:00', '23:00:00'),
(6, '2025-04-16', '13:00:00', '23:00:00'),
(6, '2025-04-17', '13:00:00', '23:00:00'),
(6, '2025-04-18', '13:00:00', '23:00:00'),
(6, '2025-04-19', '13:00:00', '23:00:00'),
(6, '2025-04-20', '13:00:00', '23:00:00'),
(6, '2025-04-21', '13:00:00', '23:00:00'),
(6, '2025-04-22', '13:00:00', '23:00:00'),
(6, '2025-04-23', '13:00:00', '23:00:00'),
(7, '2025-02-13', '13:00:00', '23:00:00'),
(7, '2025-02-14', '13:00:00', '23:00:00'),
(7, '2025-02-15', '13:00:00', '23:00:00'),
(7, '2025-02-16', '13:00:00', '23:00:00'),
(7, '2025-02-17', '13:00:00', '23:00:00'),
(7, '2025-02-18', '13:00:00', '23:00:00'),
(7, '2025-02-19', '13:00:00', '23:00:00'),
(7, '2025-02-20', '13:00:00', '23:00:00'),
(7, '2025-02-21', '13:00:00', '23:00:00'),
(7, '2025-02-22', '13:00:00', '23:00:00'),
(7, '2025-02-23', '13:00:00', '23:00:00'),
(7, '2025-02-24', '13:00:00', '23:00:00'),
(7, '2025-02-25', '13:00:00', '23:00:00'),
(7, '2025-02-26', '13:00:00', '23:00:00'),
(7, '2025-02-27', '13:00:00', '23:00:00'),
(7, '2025-02-28', '13:00:00', '23:00:00'),
(7, '2025-03-01', '13:00:00', '23:00:00'),
(7, '2025-03-02', '13:00:00', '23:00:00'),
(7, '2025-03-03', '13:00:00', '23:00:00'),
(7, '2025-03-04', '13:00:00', '23:00:00'),
(7, '2025-03-05', '13:00:00', '23:00:00'),
(7, '2025-03-06', '13:00:00', '23:00:00'),
(7, '2025-03-07', '13:00:00', '23:00:00'),
(7, '2025-03-08', '13:00:00', '23:00:00'),
(7, '2025-03-09', '13:00:00', '23:00:00'),
(7, '2025-03-10', '13:00:00', '23:00:00'),
(7, '2025-03-11', '13:00:00', '23:00:00'),
(7, '2025-03-12', '13:00:00', '23:00:00'),
(7, '2025-03-13', '13:00:00', '23:00:00'),
(7, '2025-03-14', '13:00:00', '23:00:00'),
(7, '2025-03-15', '13:00:00', '23:00:00'),
(7, '2025-03-16', '13:00:00', '23:00:00'),
(7, '2025-03-17', '13:00:00', '23:00:00'),
(7, '2025-03-18', '13:00:00', '23:00:00'),
(7, '2025-03-19', '13:00:00', '23:00:00'),
(7, '2025-03-20', '13:00:00', '23:00:00'),
(7, '2025-03-21', '13:00:00', '23:00:00'),
(7, '2025-03-22', '13:00:00', '23:00:00'),
(7, '2025-03-23', '13:00:00', '23:00:00'),
(7, '2025-03-24', '13:00:00', '23:00:00'),
(7, '2025-03-25', '13:00:00', '23:00:00'),
(7, '2025-03-26', '13:00:00', '23:00:00'),
(7, '2025-03-27', '13:00:00', '23:00:00'),
(7, '2025-03-28', '13:00:00', '23:00:00'),
(7, '2025-03-29', '13:00:00', '23:00:00'),
(7, '2025-03-30', '13:00:00', '23:00:00'),
(7, '2025-03-31', '13:00:00', '23:00:00'),
(7, '2025-04-01', '13:00:00', '23:00:00'),
(7, '2025-04-02', '13:00:00', '23:00:00'),
(7, '2025-04-03', '13:00:00', '23:00:00'),
(7, '2025-04-04', '13:00:00', '23:00:00'),
(7, '2025-04-05', '13:00:00', '23:00:00'),
(7, '2025-04-06', '13:00:00', '23:00:00'),
(7, '2025-04-07', '13:00:00', '23:00:00'),
(7, '2025-04-08', '13:00:00', '23:00:00'),
(7, '2025-04-09', '13:00:00', '23:00:00'),
(7, '2025-04-10', '13:00:00', '23:00:00'),
(7, '2025-04-11', '13:00:00', '23:00:00'),
(7, '2025-04-12', '13:00:00', '23:00:00'),
(7, '2025-04-13', '13:00:00', '23:00:00'),
(7, '2025-04-14', '13:00:00', '23:00:00'),
(7, '2025-04-15', '13:00:00', '23:00:00'),
(7, '2025-04-16', '13:00:00', '23:00:00'),
(7, '2025-04-17', '13:00:00', '23:00:00'),
(7, '2025-04-18', '13:00:00', '23:00:00'),
(7, '2025-04-19', '13:00:00', '23:00:00'),
(7, '2025-04-20', '13:00:00', '23:00:00'),
(7, '2025-04-21', '13:00:00', '23:00:00'),
(7, '2025-04-22', '13:00:00', '23:00:00'),
(7, '2025-04-23', '13:00:00', '23:00:00'),
(8, '2025-02-13', '13:00:00', '23:00:00'),
(8, '2025-02-14', '13:00:00', '23:00:00'),
(8, '2025-02-15', '13:00:00', '23:00:00'),
(8, '2025-02-16', '13:00:00', '23:00:00'),
(8, '2025-02-17', '13:00:00', '23:00:00'),
(8, '2025-02-18', '13:00:00', '23:00:00'),
(8, '2025-02-19', '13:00:00', '23:00:00'),
(8, '2025-02-20', '13:00:00', '23:00:00'),
(8, '2025-02-21', '13:00:00', '23:00:00'),
(8, '2025-02-22', '13:00:00', '23:00:00'),
(8, '2025-02-23', '13:00:00', '23:00:00'),
(8, '2025-02-24', '13:00:00', '23:00:00'),
(8, '2025-02-25', '13:00:00', '23:00:00'),
(8, '2025-02-26', '13:00:00', '23:00:00'),
(8, '2025-02-27', '13:00:00', '23:00:00'),
(8, '2025-02-28', '13:00:00', '23:00:00'),
(8, '2025-03-01', '13:00:00', '23:00:00'),
(8, '2025-03-02', '13:00:00', '23:00:00'),
(8, '2025-03-03', '13:00:00', '23:00:00'),
(8, '2025-03-04', '13:00:00', '23:00:00'),
(8, '2025-03-05', '13:00:00', '23:00:00'),
(8, '2025-03-06', '13:00:00', '23:00:00'),
(8, '2025-03-07', '13:00:00', '23:00:00'),
(8, '2025-03-08', '13:00:00', '23:00:00'),
(8, '2025-03-09', '13:00:00', '23:00:00'),
(8, '2025-03-10', '13:00:00', '23:00:00'),
(8, '2025-03-11', '13:00:00', '23:00:00'),
(8, '2025-03-12', '13:00:00', '23:00:00'),
(8, '2025-03-13', '13:00:00', '23:00:00'),
(8, '2025-03-14', '13:00:00', '23:00:00'),
(8, '2025-03-15', '13:00:00', '23:00:00'),
(8, '2025-03-16', '13:00:00', '23:00:00'),
(8, '2025-03-17', '13:00:00', '23:00:00'),
(8, '2025-03-18', '13:00:00', '23:00:00'),
(8, '2025-03-19', '13:00:00', '23:00:00'),
(8, '2025-03-20', '13:00:00', '23:00:00'),
(8, '2025-03-21', '13:00:00', '23:00:00'),
(8, '2025-03-22', '13:00:00', '23:00:00'),
(8, '2025-03-23', '13:00:00', '23:00:00'),
(8, '2025-03-24', '13:00:00', '23:00:00'),
(8, '2025-03-25', '13:00:00', '23:00:00'),
(8, '2025-03-26', '13:00:00', '23:00:00'),
(8, '2025-03-27', '13:00:00', '23:00:00'),
(8, '2025-03-28', '13:00:00', '23:00:00'),
(8, '2025-03-29', '13:00:00', '23:00:00'),
(8, '2025-03-30', '13:00:00', '23:00:00'),
(8, '2025-03-31', '13:00:00', '23:00:00'),
(8, '2025-04-01', '13:00:00', '23:00:00'),
(8, '2025-04-02', '13:00:00', '23:00:00'),
(8, '2025-04-03', '13:00:00', '23:00:00'),
(8, '2025-04-04', '13:00:00', '23:00:00'),
(8, '2025-04-05', '13:00:00', '23:00:00'),
(8, '2025-04-06', '13:00:00', '23:00:00'),
(8, '2025-04-07', '13:00:00', '23:00:00'),
(8, '2025-04-08', '13:00:00', '23:00:00'),
(8, '2025-04-09', '13:00:00', '23:00:00'),
(8, '2025-04-10', '13:00:00', '23:00:00'),
(8, '2025-04-11', '13:00:00', '23:00:00'),
(8, '2025-04-12', '13:00:00', '23:00:00'),
(8, '2025-04-13', '13:00:00', '23:00:00'),
(8, '2025-04-14', '13:00:00', '23:00:00'),
(8, '2025-04-15', '13:00:00', '23:00:00'),
(8, '2025-04-16', '13:00:00', '23:00:00'),
(8, '2025-04-17', '13:00:00', '23:00:00'),
(8, '2025-04-18', '13:00:00', '23:00:00'),
(8, '2025-04-19', '13:00:00', '23:00:00'),
(8, '2025-04-20', '13:00:00', '23:00:00'),
(8, '2025-04-21', '13:00:00', '23:00:00'),
(8, '2025-04-22', '13:00:00', '23:00:00'),
(8, '2025-04-23', '13:00:00', '23:00:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `alergias`
--

CREATE TABLE `alergias` (
  `Id_Paciente` int(11) NOT NULL,
  `Alergia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `alergias`
--

INSERT INTO `alergias` (`Id_Paciente`, `Alergia`) VALUES
(1, 'Poeira');

-- --------------------------------------------------------

--
-- Estrutura para tabela `comorbidades`
--

CREATE TABLE `comorbidades` (
  `Id_Paciente` int(11) NOT NULL,
  `Comorbidade` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `comorbidades`
--

INSERT INTO `comorbidades` (`Id_Paciente`, `Comorbidade`) VALUES
(1, 'n/a');

-- --------------------------------------------------------

--
-- Estrutura para tabela `consultas`
--

CREATE TABLE `consultas` (
  `Id_Consulta` int(11) NOT NULL,
  `Matricula_Med` int(11) NOT NULL,
  `Id_Paciente` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `consultas`
--

INSERT INTO `consultas` (`Id_Consulta`, `Matricula_Med`, `Id_Paciente`, `Data`, `Hora`) VALUES
(1, 5, 1, '2025-02-13', '15:00:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `especialidades`
--

CREATE TABLE `especialidades` (
  `Id_Especialidade` int(11) NOT NULL,
  `Nome_Especialidade` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `especialidades`
--

INSERT INTO `especialidades` (`Id_Especialidade`, `Nome_Especialidade`) VALUES
(1, 'Ortopedista_e_Traumatologista'),
(2, 'Cardiologista'),
(3, 'Dermatologista'),
(4, 'Urologista'),
(5, 'Neurologista'),
(6, 'Psiquiatra'),
(7, 'Alergista e Imunologista'),
(8, 'Angiologista'),
(9, 'Clínica Médica'),
(10, 'Endocrinologista e Metabologista'),
(11, 'Endoscopista'),
(12, 'Geriatrista'),
(13, 'Ginecologista e Obstreticista'),
(14, 'Neurologista'),
(15, 'Nutrologista'),
(16, 'Oftalmologista'),
(17, 'Pediatra');

-- --------------------------------------------------------

--
-- Estrutura para tabela `medico`
--

CREATE TABLE `medico` (
  `Matricula` int(11) NOT NULL,
  `Id_Usuario` int(11) NOT NULL,
  `Especialidade` int(11) NOT NULL,
  `Crm` char(9) NOT NULL,
  `Situacao` varchar(45) NOT NULL,
  `Rqe` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `medico`
--

INSERT INTO `medico` (`Matricula`, `Id_Usuario`, `Especialidade`, `Crm`, `Situacao`, `Rqe`) VALUES
(1, 1, 6, '555666777', 'Superposição Quântica', '3364447'),
(4, 5, 17, '320147854', 'ativo', '8425637'),
(5, 7, 1, '123456789', 'ativo', '1234567'),
(6, 8, 2, '987654321', 'ativo', '7654321'),
(7, 9, 3, '152346987', 'ativo', '7253641'),
(8, 10, 4, '503278196', 'ativo', '7405231');

-- --------------------------------------------------------

--
-- Estrutura para tabela `paciente`
--

CREATE TABLE `paciente` (
  `Id_Paciente` int(11) NOT NULL,
  `Email` varchar(90) NOT NULL,
  `Nome` varchar(90) NOT NULL,
  `Data_Nasc` date DEFAULT NULL,
  `Bairro` varchar(45) DEFAULT NULL,
  `Rua` varchar(45) DEFAULT NULL,
  `Num_Casa` varchar(45) DEFAULT NULL,
  `Municipio` varchar(45) DEFAULT NULL,
  `Plano_De_Saude` varchar(45) DEFAULT NULL,
  `CEP` char(8) DEFAULT NULL,
  `CPF` char(14) NOT NULL,
  `Telefone` char(13) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `Profissao` varchar(45) NOT NULL,
  `Sexo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `paciente`
--

INSERT INTO `paciente` (`Id_Paciente`, `Email`, `Nome`, `Data_Nasc`, `Bairro`, `Rua`, `Num_Casa`, `Municipio`, `Plano_De_Saude`, `CEP`, `CPF`, `Telefone`, `Estado`, `Profissao`, `Sexo`) VALUES
(1, 'Robs@gmail.com', 'Robson Alves Pontes', '1988-02-09', 'Jardim Paulista', 'Rua Oitenta e Sete', '22', 'Paulista', 'Sesi Saude', '53407200', '25528825588', '81966557788', 'PE', 'Professor', 'M');

-- --------------------------------------------------------

--
-- Estrutura para tabela `prontuarios`
--

CREATE TABLE `prontuarios` (
  `Id_Prontuario` int(11) NOT NULL,
  `Id_Paciente` int(11) NOT NULL,
  `Peso` decimal(10,0) NOT NULL,
  `Altura` decimal(10,0) NOT NULL,
  `Temperatura` decimal(10,0) NOT NULL,
  `Pressao_Arterial` decimal(10,0) NOT NULL,
  `Frequencia_Cardiaca` decimal(10,0) NOT NULL,
  `Queixas` varchar(100) NOT NULL,
  `Solicita_Exame` tinyint(1) NOT NULL,
  `Solicita_Atestado` tinyint(1) NOT NULL,
  `Solicita_Prescricao` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `solicitacoes_exames`
--

CREATE TABLE `solicitacoes_exames` (
  `Id_Solicitacao_Exame` int(11) NOT NULL,
  `Id_Medico` int(11) NOT NULL,
  `Id_Paciente` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Hora` time NOT NULL,
  `Exames_Solicitados` varchar(90) NOT NULL,
  `Observacoes` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `Id_Usuario` int(11) NOT NULL,
  `Email` varchar(90) NOT NULL,
  `Senha` varchar(50) DEFAULT NULL,
  `Nome` varchar(90) NOT NULL,
  `CPF` char(14) NOT NULL,
  `Data_Nasc` date DEFAULT NULL,
  `Bairro` varchar(45) DEFAULT NULL,
  `Rua` varchar(45) DEFAULT NULL,
  `Num_Casa` varchar(45) DEFAULT NULL,
  `Cidade` varchar(45) DEFAULT NULL,
  `Uf` char(2) NOT NULL,
  `Servíco` varchar(45) DEFAULT NULL,
  `Plano_De_Saude` varchar(45) DEFAULT NULL,
  `CEP` char(8) DEFAULT NULL,
  `Telefone` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`Id_Usuario`, `Email`, `Senha`, `Nome`, `CPF`, `Data_Nasc`, `Bairro`, `Rua`, `Num_Casa`, `Cidade`, `Uf`, `Servíco`, `Plano_De_Saude`, `CEP`, `Telefone`) VALUES
(1, 'adminicial@gmail.com', 'E10ADC3949BA59ABBE56E057F20F883E', 'Lorem Ipsum Dolor', '55566677733', '1950-12-08', 'Lorem', 'Ipsum', '6', 'Dolor', '', 'Administrador', '', '44477777', '88636665556'),
(5, 'RodrigoMVP@gmail.com', 'D41D8CD98F00B204E9800998ECF8427E', 'Rodrigo Moura Valério Pinto', '15524478812', '1990-06-03', 'Jardim Paulista', 'Rua Cento e Quatro', '987', 'Paulista', 'PE', 'Médico', '', '53407230', '81955662023'),
(6, 'eduhernandes@gmail.com', '7F456558609739CE7506D24643DC0344', 'Eduardo Hernandes', '2882886558', '1995-06-08', 'Jardim Paulista', 'Rua Cento e Cinco', '855', 'Paulista', '', 'Secretária', 'Sesi Saude', '53407240', '81955663214'),
(7, 'WinstonWW@gmail.com', 'FCAEEB6E34B4303E99B91206BD325F2B', 'Winston Winton Wesley', '944.466.777-78', '2025-12-31', 'Jardim Paulista', 'Rua Noventa e Dois', '98', 'Paulista', 'PE', 'Médico', 'SaudeWatch', '53407050', '(81)966666254'),
(8, 'amercy@gmail.com', '4BE5AA752692896D9DA892ECD63F48B3', 'Angela Ziegler ', '896.452.317-55', '1970-07-06', 'Jaguaribe', 'Rua Vinte e Três', '78', 'Paulista', 'PE', 'Médico', 'Cajado', '53422350', '(81)955667744'),
(9, 'Moira@gmail.com', '18F44B1A7909F6054AFCBAAFC0AED75C', 'Moira O\'Deorain', '696.676.626-66', '1900-02-05', 'Centro', 'Rua Sapucaia', '66', 'Paulista', 'PE', 'Médico', '', '53401500', '(81)984523167'),
(10, 'eobaptiste@gmail.com', '0EEFD5AF52A4348911731ECB280786CF', 'Jean-Baptiste Augustin', '147.258.369-52', '1970-11-09', 'Tabajara', 'Rua Professor Luiz Cavalcante', '88', 'Paulista', 'PE', 'Médico', 'Overwatch', '53404230', '(81)955748210');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`matricula_medico`,`dia`);

--
-- Índices de tabela `alergias`
--
ALTER TABLE `alergias`
  ADD PRIMARY KEY (`Id_Paciente`,`Alergia`);

--
-- Índices de tabela `comorbidades`
--
ALTER TABLE `comorbidades`
  ADD PRIMARY KEY (`Id_Paciente`,`Comorbidade`);

--
-- Índices de tabela `consultas`
--
ALTER TABLE `consultas`
  ADD PRIMARY KEY (`Id_Consulta`),
  ADD KEY `Matricula_Med` (`Matricula_Med`),
  ADD KEY `Id_Paciente` (`Id_Paciente`);

--
-- Índices de tabela `especialidades`
--
ALTER TABLE `especialidades`
  ADD PRIMARY KEY (`Id_Especialidade`);

--
-- Índices de tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`Matricula`),
  ADD KEY `fk_especialidade` (`Especialidade`),
  ADD KEY `medico_ibfk_1` (`Id_Usuario`);

--
-- Índices de tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`Id_Paciente`),
  ADD UNIQUE KEY `Id_Paciente` (`Id_Paciente`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Índices de tabela `prontuarios`
--
ALTER TABLE `prontuarios`
  ADD PRIMARY KEY (`Id_Prontuario`),
  ADD KEY `Id_Paciente` (`Id_Paciente`);

--
-- Índices de tabela `solicitacoes_exames`
--
ALTER TABLE `solicitacoes_exames`
  ADD PRIMARY KEY (`Id_Solicitacao_Exame`),
  ADD KEY `Id_Medico` (`Id_Medico`),
  ADD KEY `Id_Paciente` (`Id_Paciente`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id_Usuario`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `consultas`
--
ALTER TABLE `consultas`
  MODIFY `Id_Consulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `especialidades`
--
ALTER TABLE `especialidades`
  MODIFY `Id_Especialidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `medico`
--
ALTER TABLE `medico`
  MODIFY `Matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `Id_Paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `prontuarios`
--
ALTER TABLE `prontuarios`
  MODIFY `Id_Prontuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `solicitacoes_exames`
--
ALTER TABLE `solicitacoes_exames`
  MODIFY `Id_Solicitacao_Exame` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `agenda`
--
ALTER TABLE `agenda`
  ADD CONSTRAINT `agenda_ibfk_1` FOREIGN KEY (`matricula_medico`) REFERENCES `medico` (`Matricula`);

--
-- Restrições para tabelas `alergias`
--
ALTER TABLE `alergias`
  ADD CONSTRAINT `alergias_ibfk_1` FOREIGN KEY (`Id_Paciente`) REFERENCES `paciente` (`Id_Paciente`);

--
-- Restrições para tabelas `comorbidades`
--
ALTER TABLE `comorbidades`
  ADD CONSTRAINT `comorbidades_ibfk_1` FOREIGN KEY (`Id_Paciente`) REFERENCES `paciente` (`Id_Paciente`);

--
-- Restrições para tabelas `consultas`
--
ALTER TABLE `consultas`
  ADD CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`Matricula_Med`) REFERENCES `medico` (`Matricula`),
  ADD CONSTRAINT `consultas_ibfk_2` FOREIGN KEY (`Id_Paciente`) REFERENCES `paciente` (`Id_Paciente`);

--
-- Restrições para tabelas `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `fk_especialidade` FOREIGN KEY (`Especialidade`) REFERENCES `especialidades` (`Id_Especialidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuarios` (`Id_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `prontuarios`
--
ALTER TABLE `prontuarios`
  ADD CONSTRAINT `prontuarios_ibfk_1` FOREIGN KEY (`Id_Paciente`) REFERENCES `paciente` (`Id_Paciente`);

--
-- Restrições para tabelas `solicitacoes_exames`
--
ALTER TABLE `solicitacoes_exames`
  ADD CONSTRAINT `solicitacoes_exames_ibfk_1` FOREIGN KEY (`Id_Medico`) REFERENCES `medico` (`Matricula`),
  ADD CONSTRAINT `solicitacoes_exames_ibfk_2` FOREIGN KEY (`Id_Paciente`) REFERENCES `paciente` (`Id_Paciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
