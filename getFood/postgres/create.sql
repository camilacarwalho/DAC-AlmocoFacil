--CRIACAO DA TABELA PESSOA
CREATE TABLE pessoa
(
  cpf character varying(14) NOT NULL,
  nome character varying(255) NOT NULL,
  telefone character varying(20),
  CONSTRAINT pessoa_pkey PRIMARY KEY (cpf)
);

--CRIACAO DA TABELA USUARIO
CREATE TABLE usuario
(
  matricula character varying(20) NOT NULL,
  cargo character varying(20) NOT NULL,
  senha character varying(255) NOT NULL,
  pessoa_cpf character varying(14),
  CONSTRAINT usuario_pkey PRIMARY KEY (matricula),
  CONSTRAINT fk_usuario_pessoa_cpf FOREIGN KEY (pessoa_cpf)
      REFERENCES pessoa (cpf) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--CRIACAO DA TABELA CURSO
CREATE TABLE curso
(
  codigo character varying(10) NOT NULL,
  nivel character varying(20) NOT NULL,
  nome character varying(255) NOT NULL,
  turno character varying(20) NOT NULL,
  CONSTRAINT curso_pkey PRIMARY KEY (codigo)
);

--CRIACAO DA TABELA PERIODO
CREATE TABLE periodo
(
  codigo character varying(10) NOT NULL,
  ano integer NOT NULL,
  periodo integer NOT NULL,
  datainicio date NOT NULL,
  datafinal date NOT NULL,    
  CONSTRAINT periodo_pkey PRIMARY KEY (codigo)
);

--CRIACAO DA TABELA ALUNO
CREATE TABLE aluno
(
  matricula character varying(20) NOT NULL,
  cargo character varying(20) NOT NULL,
  senha character varying(255) NOT NULL,
  curso_codigo character varying(10) NOT NULL,
  periodoingresso_codigo character varying(10) NOT NULL,
  pessoa_cpf character varying(14),
  CONSTRAINT aluno_pkey PRIMARY KEY (matricula),
  CONSTRAINT fk_aluno_curso_codigo FOREIGN KEY (curso_codigo)
      REFERENCES curso (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_aluno_periodoingresso_codigo FOREIGN KEY (periodoingresso_codigo)
      REFERENCES periodo (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_aluno_pessoa_cpf FOREIGN KEY (pessoa_cpf)
      REFERENCES pessoa (cpf) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--CRIACAO DA TABELA REFEICAO
CREATE TABLE refeicao
(
  id bigint NOT NULL,
  horainicio time without time zone,
  horatermino time without time zone,
  nome character varying(20),
  CONSTRAINT refeicao_pkey PRIMARY KEY (id)
);

--CRIACAO DA TABELA SOLICITACAO
CREATE TABLE solicitacao
(
  id bigint NOT NULL,
  datasolicitacao date,
  descricao character varying(255),
  justificativa character varying(255),
  statusrequisicao character varying(20),
  usuario_matricula character varying(20),
  CONSTRAINT solicitacao_pkey PRIMARY KEY (id)
);

--CRIACAO DA TABELA REQUISICAO
CREATE TABLE requisicao
(
  id bigint NOT NULL,
  solicitacao_id bigint,
  datainicial date,
  datafinal date,
  statusrequisicao character varying(20),
  refeicao_id bigint,
  CONSTRAINT requisicao_pkey PRIMARY KEY (id),
  CONSTRAINT fk_requisicao_refeicao_id FOREIGN KEY (refeicao_id)
      REFERENCES refeicao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--CRIACAO DA TABELA AUTORIZACAO
CREATE TABLE autorizacao
(
  id bigint NOT NULL,
  data date,
  hora time without time zone,
  statusautorizacao character varying(20),
  requisicao_id bigint,
  aluno_matricula character varying(20),
  refeicao_id bigint,
  CONSTRAINT autorizacao_pkey PRIMARY KEY (id),
  CONSTRAINT fk_autorizacao_aluno_matricula FOREIGN KEY (aluno_matricula)
      REFERENCES aluno (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_autorizacao_refeicao_id FOREIGN KEY (refeicao_id)
      REFERENCES refeicao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_autorizacao_requisicao_id FOREIGN KEY (requisicao_id)
      REFERENCES requisicao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--CRIACAO DA TABELA EDITAL
CREATE TABLE edital
(
  codigo character varying(20) NOT NULL,
  id bigint NOT NULL,
  datasolicitacao date,
  descricao character varying(255),
  justificativa character varying(255),
  statusrequisicao character varying(20),
  periodo_codigo character varying(10) NOT NULL,
  usuario_matricula character varying(20),
  CONSTRAINT edital_pkey PRIMARY KEY (codigo, id),
  CONSTRAINT fk_edital_periodo_codigo FOREIGN KEY (periodo_codigo)
      REFERENCES periodo (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--CRIACAO DA TABELA DE JUNCAO ENTRE REQUISICAO E ALUNO
CREATE TABLE requisicao_aluno
(
  requisicao_id bigint NOT NULL,
  alunos_matricula character varying(20) NOT NULL,
  CONSTRAINT requisicao_aluno_pkey PRIMARY KEY (requisicao_id, alunos_matricula),
  CONSTRAINT fk_requisicao_aluno_alunos_matricula FOREIGN KEY (alunos_matricula)
      REFERENCES aluno (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_requisicao_aluno_requisicao_id FOREIGN KEY (requisicao_id)
      REFERENCES requisicao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--CRIACAO DA TABELA SEQUENCE
CREATE TABLE sequence
(
  seq_name character varying(50) NOT NULL,
  seq_count numeric(38,0),
  CONSTRAINT sequence_pkey PRIMARY KEY (seq_name)
);






