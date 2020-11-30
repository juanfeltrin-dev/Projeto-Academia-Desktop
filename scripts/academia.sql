drop database if exists academia;
create database academia;

use academia;


CREATE TABLE PESSOAS(
    id_pessoa int not null auto_increment,
    cpf varchar(14) unique not null,
    nome varchar(100) not null,
    nascimento date not null,
    sexo char(1) not null,
    telefone varchar(13),
    celular varchar(14),
    email varchar(255) not null,
    bairro varchar(255) not null,
    cidade varchar (100) not null,
    estado char (2) not null,
    cep varchar(10) not null,
    primary key(id_pessoa)
);  

CREATE TABLE MODALIDADES (
    id_modalidade int not null auto_increment,
    nome varchar(55) not null,
    primary key(id_modalidade)    
);
    
CREATE TABLE INSTRUTORES(
    id_instrutor int not null auto_increment,
    id_pessoa int not null,
    data_admissao date not null,
    salario double not null,
    primary key (id_instrutor),
    foreign key(id_pessoa) references PESSOAS(id_pessoa)
);

CREATE TABLE TURMAS(
	id_turma int not null auto_increment,
    nome varchar(55) not null,
    quantidade_vagas int(3) not null,
    id_instrutor int not null,
    id_modalidade int not null,
    primary key(id_turma),
    foreign key(id_instrutor) references INSTRUTORES(id_instrutor),
    foreign key(id_modalidade) references MODALIDADES(id_modalidade)
);
    
CREATE TABLE ALUNOS(
    id_aluno int not null auto_increment,
    id_pessoa int not null,
    observacoes text,
    data_matricula date not null,
    matricula varchar(10),
    id_turma int not null,
    primary key (id_aluno),
    foreign key(id_pessoa) references PESSOAS(id_pessoa),
    foreign key(id_turma) references TURMAS(id_turma)
);

CREATE TABLE CHECK_IN(
	ID_CHECK_IN INT NOT NULL AUTO_INCREMENT,
    ID_ALUNO INT NOT NULL,
    ID_TURMA INT NOT NULL,
    DATA DATE NOT NULL,
    HORA TIME NOT NULL,
    PRIMARY KEY(ID_CHECK_IN),
    FOREIGN KEY(ID_ALUNO) REFERENCES ALUNOS(ID_ALUNO),
    FOREIGN KEY(ID_TURMA) REFERENCES TURMAS(ID_TURMA)
);

CREATE TABLE DIAS_SEMANA(
	ID_DIA_SEMANA INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(20) NOT NULL,
    PRIMARY KEY(ID_DIA_SEMANA)
);

CREATE TABLE DIA_SEMANA_TURMAS(
	ID_DIA_SEMANA_TURMA INT NOT NULL AUTO_INCREMENT,
    ID_TURMA INT NOT NULL,
    ID_DIA_SEMANA INT NOT NULL,
    HORA TIME NOT NULL,
    PRIMARY KEY(ID_DIA_SEMANA_TURMA),
    FOREIGN KEY(ID_TURMA) REFERENCES TURMAS(ID_TURMA),
    FOREIGN KEY(ID_DIA_SEMANA) REFERENCES DIAS_SEMANA(ID_DIA_SEMANA)
);

INSERT INTO MODALIDADES(nome) VALUES('Musculação');

INSERT INTO DIAS_SEMANA(NOME) 
VALUES ('Segunda-feira'), ('Terça-feira'), ('Quarta-feira'), ('Quinta-feira'), ('Sexta-feira');