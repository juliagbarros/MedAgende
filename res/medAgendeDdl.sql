
-- Banco de dados: `medagende(real)`
-- Autor do script: Lucas Leandro


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


-- --------------------------------------------------------

--
-- Estrutura para tabela `consultas`
--

CREATE TABLE `consultas` (
  `id_Consultas` int(11) NOT NULL,
  `Fk_Id_Paciente` int(11) NOT NULL,
  `Fk_Matricula_Medico` int(11) NOT NULL,
  `Data_Consulta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `medico`
--

CREATE TABLE `medico` (
  `Matricula` int(11) NOT NULL,
  `Id_Usuario` int(11) NOT NULL,
  `Especialidade` varchar(45) NOT NULL,
  `Crm` char(9) NOT NULL,
  `Situacao` varchar(45) NOT NULL,
  `Rqe` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `Senha` varchar(45) NOT NULL,
  `CPF` varchar(45) NOT NULL,
  `Telefone` char(11) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `telefone`
--

CREATE TABLE `telefone` (
  `Id_Dono` int(11) NOT NULL,
  `Telefone` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `Id_Usuario` int(11) NOT NULL,
  `Email` varchar(90) NOT NULL,
  `Nome` varchar(90) NOT NULL,
  `Data_Nasc` date DEFAULT NULL,
  `Bairro` varchar(45) DEFAULT NULL,
  `Rua` varchar(45) DEFAULT NULL,
  `Num_Casa` varchar(45) DEFAULT NULL,
  `Cidade` varchar(45) DEFAULT NULL,
  `Servíco` varchar(45) DEFAULT NULL,
  `Plano_De_Saude` varchar(45) DEFAULT NULL,
  `CEP` char(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `consultas`
--
ALTER TABLE `consultas`
  ADD PRIMARY KEY (`id_Consultas`),
  ADD KEY `Fk_Id_Paciente` (`Fk_Id_Paciente`),
  ADD KEY `Id_Consulta` (`Fk_Matricula_Medico`);

--
-- Índices de tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`Matricula`),
  ADD KEY `Id_Usuario` (`Id_Usuario`);

--
-- Índices de tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`Id_Paciente`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Id_Paciente` (`Id_Paciente`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Índices de tabela `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`Id_Dono`,`Telefone`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id_Usuario`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Id_Usuario` (`Id_Usuario`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `consultas`
--
ALTER TABLE `consultas`
  MODIFY `id_Consultas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `Id_Paciente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `consultas`
--
ALTER TABLE `consultas`
  ADD CONSTRAINT `Id_Consulta` FOREIGN KEY (`Fk_Matricula_Medico`) REFERENCES `medico` (`Matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`Fk_Id_Paciente`) REFERENCES `paciente` (`Id_Paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuarios` (`Id_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `telefone`
--
ALTER TABLE `telefone`
  ADD CONSTRAINT `telefone_ibfk_1` FOREIGN KEY (`Id_Dono`) REFERENCES `usuarios` (`Id_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
