
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
-- Estrutura para tabela `alergias`
--

CREATE TABLE `alergias` (
  `Id_Paciente` int(11) NOT NULL,
  `Alergia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `comorbidades`
--

CREATE TABLE `comorbidades` (
  `Id_Paciente` int(11) NOT NULL,
  `Comorbidade` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `consultas`
--

CREATE TABLE `consultas` (
  `id_Consultas` int(11) NOT NULL,
  `Fk_Id_Paciente` int(11) NOT NULL,
  `Fk_Matricula_Medico` int(11) NOT NULL,
  `Data_Consulta` date NOT NULL,
  `Horario_Consulta` time NOT NULL,
  `Regiao_Consulta` varchar(45) NOT NULL,
  `Bairro_Consulta` varchar(45) NOT NULL,
  `Cidade_Consulta` varchar(45) NOT NULL,
  `Situacao` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(1, 'Ortopedista'),
(2, 'Cardiologista'),
(3, 'Dermatologista'),
(4, 'Urologista'),
(5, 'Neurologista'),
(6, 'Psiquiatra');

-- --------------------------------------------------------
-- Despejando dados para tabela 'especialidades'
--
INSERT INTO `especialidades`(`Nome_Especialidade`) VALUES ('Alergista e Imunologista'), ('Angiologista'), ('Clínica Médica'), ('Endocrinologista e Metabologista'),
 ('Endoscopista'), ('Geriatrista'), ('Ginecologista e Obstreticista'), ('Neurologista'), ('Nutrologista'), ('Oftalmologista'), ('Pediatra')

-- ----------------------------------------------------------
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
(1, 1, 6, '555666777', 'Superposição Quântica', '3364447');

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
  `CPF` char(11) NOT NULL,
  `Telefone` char(11) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `Profissao` varchar(45) NOT NULL,
  `Sexo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `Senha` varchar(15) NOT NULL,
  `Nome` varchar(90) NOT NULL,
  `CPF` char(11) NOT NULL,
  `Data_Nasc` date DEFAULT NULL,
  `Bairro` varchar(45) DEFAULT NULL,
  `Rua` varchar(45) DEFAULT NULL,
  `Num_Casa` varchar(45) DEFAULT NULL,
  `Cidade` varchar(45) DEFAULT NULL,
  `Servíco` varchar(45) DEFAULT NULL,
  `Plano_De_Saude` varchar(45) DEFAULT NULL,
  `CEP` char(8) DEFAULT NULL,
  `Telefone` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`Id_Usuario`, `Email`, `Senha`, `Nome`, `CPF`, `Data_Nasc`, `Bairro`, `Rua`, `Num_Casa`, `Cidade`, `Servíco`, `Plano_De_Saude`, `CEP`, `Telefone`) VALUES
(1, 'adminicial@gmail.com', '123456', 'Lorem Ipsum Dolor', '55566677733', '0000-00-00', 'Lorem', 'Ipsum', '6', 'Dolor', 'Administrador', '', '44477777', '88636665556');

--
-- Índices para tabelas despejadas
--

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
  ADD PRIMARY KEY (`id_Consultas`),
  ADD UNIQUE KEY `id_Consultas` (`id_Consultas`),
  ADD KEY `Fk_Matricula_Medico` (`Fk_Matricula_Medico`),
  ADD KEY `Fk_Id_Paciente` (`Fk_Id_Paciente`);

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
  MODIFY `id_Consultas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `especialidades`
--
ALTER TABLE `especialidades`
  MODIFY `Id_Especialidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `medico`
--
ALTER TABLE `medico`
  MODIFY `Matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `Id_Paciente` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para tabelas despejadas
--

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
  ADD CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`Fk_Matricula_Medico`) REFERENCES `medico` (`Matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `consultas_ibfk_2` FOREIGN KEY (`Fk_Id_Paciente`) REFERENCES `paciente` (`Id_Paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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




