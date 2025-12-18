package Back;

public class Cadastro {


CREATE DATABASE IF NOT EXISTS sistema_agendamentos;
USE sistema_agendamentos;


-- TABELA BASE DE USUÁRIOS

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('ADMIN', 'SECRETARIA', 'MEDICO', 'PACIENTE') NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- TABELA MÉDICO (DADOS COMPLEMENTARES)

CREATE TABLE medico (
    id_medico INT PRIMARY KEY,
    crm VARCHAR(20) NOT NULL UNIQUE,
    especialidade VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_medico) REFERENCES usuario(id_usuario) ON DELETE CASCADE
);

-- TABELA PACIENTE (DADOS COMPLEMENTARES)

CREATE TABLE paciente (
    id_paciente INT PRIMARY KEY,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(200),
    FOREIGN KEY (id_paciente) REFERENCES usuario(id_usuario) ON DELETE CASCADE
);


CREATE TABLE agendamento (
    id_agendamento INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT NOT NULL,
    id_medico INT NOT NULL,
    data DATE NOT NULL,
    horario TIME NOT NULL,
    status ENUM('PENDENTE', 'CONFIRMADO', 'CANCELADO') DEFAULT 'PENDENTE',
    criado_por INT NOT NULL,   -- quem marcou: paciente ou secretária
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente) ON DELETE CASCADE,
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico) ON DELETE CASCADE,
    FOREIGN KEY (criado_por) REFERENCES usuario(id_usuario)
);

CREATE TABLE historico_agendamento (
    id_historico INT AUTO_INCREMENT PRIMARY KEY,
    id_agendamento INT NOT NULL,
    status_anterior ENUM('PENDENTE', 'CONFIRMADO', 'CANCELADO'),
    status_novo ENUM('PENDENTE', 'CONFIRMADO', 'CANCELADO'),
    alterado_por INT NOT NULL,
    alterado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento) ON DELETE CASCADE,
    FOREIGN KEY (alterado_por) REFERENCES usuario(id_usuario)
);

CREATE TABLE prescricao (
    id_prescricao INT AUTO_INCREMENT PRIMARY KEY,
    id_agendamento INT NOT NULL,
    id_medico INT NOT NULL,
    tipo ENUM('MEDICAMENTO', 'EXAME', 'ORIENTACAO') NOT NULL,
    descricao TEXT NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento) ON DELETE CASCADE,
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico) ON DELETE CASCADE
);


CREATE TABLE relatorio (
    id_relatorio INT AUTO_INCREMENT PRIMARY KEY,
    id_medico INT NOT NULL,
    id_paciente INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    conteudo TEXT NOT NULL,
    prioridade ENUM('BAIXA', 'MEDIA', 'ALTA') DEFAULT 'MEDIA',
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);

CREATE TABLE agenda_medico (
    id_agenda INT AUTO_INCREMENT PRIMARY KEY,
    id_medico INT NOT NULL,
    dia_semana ENUM('SEG', 'TER', 'QUA', 'QUI', 'SEX', 'SAB') NOT NULL,
    horario_inicio TIME NOT NULL,
    horario_fim TIME NOT NULL,
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico) ON DELETE CASCADE
);

}
