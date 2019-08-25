-------------------------------------------------------------------------------------------------------------------------
-- CURSO
-------------------------------------------------------------------------------------------------------------------------
-- CURSOS INTEGRADOS
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('21', 'INTEGRADO', 'Técnico em Edificações Integrado', 'INTEGRAL'); --21
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('20', 'INTEGRADO', 'Técnico em Eletromecânica Integrado', 'INTEGRAL'); --20
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('23', 'INTEGRADO', 'Técnico em Informática Integrado', 'INTEGRAL'); --23
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('18', 'INTEGRADO', 'Técnico em Meio Ambiente Integrado (PROEJA)', 'NOTURNO'); --18
-- CURSOS SUBSEQUENTES
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('049', 'SUBSEQUENTE', 'Técnico em Edificações Subsequente', 'NOTURNO'); --049
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('50', 'SUBSEQUENTE', 'Técnico em Eletromecânica Subsequente', 'NOTURNO'); --50
-- CURSOS DE GRADUACAO
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('220', 'GRADUACAO', 'Bacharelado em Engenharia Civil', 'INTEGRAL'); --220
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('224', 'GRADUACAO', 'Bacharelado em Engenharia de Controle e Automação', 'INTEGRAL'); --224
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('202', 'GRADUACAO', 'Licenciatura em Matemática', 'NOTURNO'); --202
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('201', 'GRADUACAO', 'Tecnologia em Análise e Desenvolvimento de Sistemas', 'INTEGRAL'); --201
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('203', 'GRADUACAO', 'Tecnologia em Automação Industrial', 'INTEGRAL'); --203
-- CURSO DE POS-GRADUACOA
INSERT INTO public.curso(codigo, nivel, nome, turno) VALUES ('221', 'POSGRADUACAO', 'Especialização em Matemática', 'INTEGRAL'); --221

-------------------------------------------------------------------------------------------------------------------------
-- REFEICAO
-------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.refeicao(id, horainicio, horatermino, nome) VALUES (1, '11:00:00', '13:00:00', 'Almoço');
INSERT INTO public.refeicao(id, horainicio, horatermino, nome) VALUES (2, '17:00:00', '20:00:00', 'Jantar');

-------------------------------------------------------------------------------------------------------------------------
-- PERIODO
-------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2010.1', 2010, 1, '2010-02-01', '2010-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2010.2', 2010, 2, '2010-07-08', '2010-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2011.1', 2011, 1, '2011-02-01', '2011-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2011.2', 2011, 2, '2011-07-08', '2011-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2012.1', 2012, 1, '2012-02-01', '2012-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2012.2', 2012, 2, '2012-07-08', '2012-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2013.1', 2013, 1, '2013-02-01', '2013-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2013.2', 2013, 2, '2013-07-08', '2013-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2014.1', 2014, 1, '2014-02-01', '2014-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2014.2', 2014, 2, '2014-07-08', '2014-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2016.1', 2016, 1, '2016-02-01', '2016-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2016.2', 2016, 2, '2016-07-08', '2016-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2017.1', 2017, 1, '2017-02-01', '2017-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2017.2', 2017, 2, '2017-07-08', '2017-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2018.1', 2018, 1, '2018-02-01', '2018-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2018.2', 2018, 2, '2018-07-08', '2018-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2019.1', 2019, 1, '2019-02-01', '2019-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2019.2', 2019, 2, '2019-07-08', '2019-11-30');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2020.1', 2020, 1, '2020-02-01', '2020-06-20');
INSERT INTO public.periodo(codigo, ano, periodo, datafinal, datainicio) VALUES ('2020.2', 2020, 2, '2020-07-08', '2020-11-30');

-------------------------------------------------------------------------------------------------------------------------
-- ALUNOS
-------------------------------------------------------------------------------------------------------------------------
-- Técnico em Edificações Integrado
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('877.385.669-06', 'Mariana Sophia Eduarda Teixeira', '(83) 98411-4910');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191210001', 'ALUNO', '123', '21', '2019.1', '877.385.669-06');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('943.068.079-08', 'Marcela Rayssa Débora Moura', '(83) 99805-9054');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191210002', 'ALUNO', '123', '21', '2019.1', '943.068.079-08');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('421.471.425-30', 'Márcio Emanuel da Rocha', '(83) 99993-1079');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191210003', 'ALUNO', '123', '21', '2019.1', '421.471.425-30');
-- Técnico em Eletromecânica Integrado
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('791.632.711-25', 'Jéssica Tereza Brenda Figueiredo', '(83) 98352-3803');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191200001', 'ALUNO', '123', '20', '2019.1', '791.632.711-25');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('918.542.355-67', 'Ricardo Bryan Nunes', '(83) 99509-0321');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191200002', 'ALUNO', '123', '20', '2019.1', '918.542.355-67');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('036.127.458-08', 'Bruna Nicole Cavalcanti', '(83) 98888-7004');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191200003', 'ALUNO', '123', '20', '2019.1', '036.127.458-08');
-- Técnico em Informática Integrado
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('056.836.888-68', 'Teresinha Maitê Luana Fogaça', '(83) 99986-9636');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191230001', 'ALUNO', '123', '23', '2019.1', '056.836.888-68');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('593.452.199-35', 'Marli Rosa Mendes', '(83) 99354-7690');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191230002', 'ALUNO', '123', '23', '2019.1', '593.452.199-35');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('774.312.913-61', 'Analu Lúcia Clara Aparício', '(83) 99922-1090');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191230003', 'ALUNO', '123', '23', '2019.1', '774.312.913-61');
-- Técnico em Meio Ambiente Integrado (PROEJA)
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('462.783.884-05', 'Hadassa Bárbara Analu Araújo', '(83) 98289-9779');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191180001', 'ALUNO', '123', '18', '2019.1', '462.783.884-05');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('291.289.980-06', 'Ryan Thales Martin Vieira', '(83) 98968-7504');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191180002', 'ALUNO', '123', '18', '2019.1', '291.289.980-06');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('289.876.481-76', 'Cláudia Clarice Juliana da Rosa', '(83) 99827-5852');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191180003', 'ALUNO', '123', '18', '2019.1', '289.876.481-76');
-- Técnico em Edificações Subsequente
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('842.118.960-32', 'Anthony Manuel Lorenzo da Mata', '(83) 98995-6952');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201910490001', 'ALUNO', '123', '049', '2019.1', '842.118.960-32');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('855.424.047-23', 'Antonella Agatha da Luz', '(83) 99384-3420');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201910490002', 'ALUNO', '123', '049', '2019.1', '855.424.047-23');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('511.365.795-67', 'Evelyn Sarah Araújo', '(83) 99353-1706');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201910490003', 'ALUNO', '123', '049', '2019.1', '511.365.795-67');
-- Técnico em Eletromecânica Subsequente
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('233.775.471-50', 'Mário Kauê Duarte', '(83) 98335-6633');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191500001', 'ALUNO', '123', '50', '2019.1', '233.775.471-50');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('797.153.886-39', 'Mateus Cauã Aragão', '(83) 99611-4693');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191500002', 'ALUNO', '123', '50', '2019.1', '797.153.886-39');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('810.024.628-94', 'Arthur Oliver Baptista', '(83) 99204-1236');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('20191500003', 'ALUNO', '123', '50', '2019.1', '810.024.628-94');
-- Bacharelado em Engenharia Civil
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('696.009.476-35', 'Julio Gabriel Porto', '(83) 98187-1039');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912200001', 'ALUNO', '123', '220', '2019.1', '696.009.476-35');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('683.455.495-51', 'Danilo João Ruan Porto', '(83) 99389-9258');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912200002', 'ALUNO', '123', '220', '2019.1', '683.455.495-51');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('942.831.099-91', 'Murilo Erick da Silva', '(83) 98883-1908');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912200003', 'ALUNO', '123', '220', '2019.1', '942.831.099-91');
-- Bacharelado em Engenharia de Controle e Automação
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('579.411.320-01', 'Lara Kamilly Peixoto', '(83) 99175-0198');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912240001', 'ALUNO', '123', '224', '2019.1', '579.411.320-01');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('233.994.182-21', 'Heitor Anthony Costa', '(83) 98205-3149');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912240002', 'ALUNO', '123', '224', '2019.1', '233.994.182-21');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('271.803.208-11', 'Giovanni Alexandre Osvaldo da Costa', '(83) 99998-6762');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912240003', 'ALUNO', '123', '224', '2019.1', '271.803.208-11');
-- Licenciatura em Matemática
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('879.855.527-82', 'Raul Juan Monteiro', '(83) 99491-1110');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912020001', 'ALUNO', '123', '202', '2019.1', '879.855.527-82');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('685.596.617-94', 'Bento Tiago Filipe Oliveira', '(83) 99608-5835');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912020002', 'ALUNO', '123', '202', '2019.1', '685.596.617-94');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('989.964.800-02', 'Theo Márcio Diogo das Neves', '(83) 98262-3316');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912020003', 'ALUNO', '123', '202', '2019.1', '989.964.800-02');
-- Tecnologia em Análise e Desenvolvimento de Sistemas
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('060.693.909-11', 'Kauê Benício Almada', '(83) 99401-4430');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912010001', 'ALUNO', '123', '201', '2019.1', '060.693.909-11');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('975.990.320-29', 'Rodrigo Paulo Almada', '(83) 98370-0908');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912010002', 'ALUNO', '123', '201', '2019.1', '975.990.320-29');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('199.208.293-66', 'Márcio Emanuel Moura', '(83) 98116-4840');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912010003', 'ALUNO', '123', '201', '2019.1', '199.208.293-66');
-- Tecnologia em Automação Industrial
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('317.439.020-69', 'Elias Calebe Martin Nunes', '(83) 98478-5428');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912030001', 'ALUNO', '123', '203', '2019.1', '317.439.020-69');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('808.593.011-09', 'Ryan Sebastião Tiago da Cruz', '(83) 99911-7773');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912030002', 'ALUNO', '123', '203', '2019.1', '808.593.011-09');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('380.598.271-20', 'Ana Sophia da Rocha', '(83) 99444-0650');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912030003', 'ALUNO', '123', '203', '2019.1', '380.598.271-20');
-- Especialização em Matemática
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('497.838.589-04', 'Raquel Mariah Sarah Almada', '(83) 99561-1525');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912210001', 'ALUNO', '123', '221', '2019.1', '497.838.589-04');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('188.700.325-82', 'Henry Cauê Mário da Luz', '(83) 98784-1644');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912210002', 'ALUNO', '123', '221', '2019.1', '188.700.325-82');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('649.580.135-12', 'Laís Tânia Lopes', '(83) 99573-9831');
INSERT INTO public.aluno(matricula, cargo, senha, curso_codigo, periodoingresso_codigo, pessoa_cpf)	VALUES ('201912210003', 'ALUNO', '123', '221', '2019.1', '649.580.135-12');

-------------------------------------------------------------------------------------------------------------------------
-- PROFESSOR
-------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('620.708.743-70', 'Carlos Leonardo Silva', '(83) 98884-7945');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000001', 'PROFESSOR', '123', '620.708.743-70');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('419.357.292-76', 'Louise Olivia Isabela da Silva', '(83) 99834-0259');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000002', 'PROFESSOR', '123', '419.357.292-76');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('431.881.031-31', 'Jennifer Olivia Gonçalves', '(83) 98232-9573');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000003', 'PROFESSOR', '123', '431.881.031-31');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('231.560.134-71', 'Vitória Rosângela Brito', '(83) 99377-7717');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000004', 'PROFESSOR', '123', '231.560.134-71');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('691.469.546-60', 'Cláudio Danilo Kevin Aragão', '(83) 98688-2249');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000005', 'PROFESSOR', '123', '691.469.546-60');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('254.137.386-41', 'Joana Milena da Mota', '(83) 99454-7828');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000006', 'PROFESSOR', '123', '254.137.386-41');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('693.230.058-35', 'Raimundo Severino Cavalcanti', '(83) 98677-2124');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000007', 'PROFESSOR', '123', '693.230.058-35');
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('558.320.555-51', 'Fernanda Allana Laís Martins', '(83) 99403-8971');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000008', 'PROFESSOR', '123', '558.320.555-51');
--Professor e Gestor
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('111.111.111-01', 'Marcos Vinicius Victor Manuel Rezende', '(83) 99394-2230');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000009', 'PROFESSOR', '123', '111.111.111-01');
--Professor e CAEST
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('222.222.222-02', 'Marina Pietra Barros', '(83) 99314-1536');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('5000010', 'PROFESSOR', '123', '222.222.222-02');

-------------------------------------------------------------------------------------------------------------------------
-- GESTOR
-------------------------------------------------------------------------------------------------------------------------
-- INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('111.111.111-01', 'Marcos Vinicius Victor Manuel Rezende', '(83) 99394-2230');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('111.111.111-01', 'GESTOR', '123', '111.111.111-01');

-------------------------------------------------------------------------------------------------------------------------
-- CAEST
-------------------------------------------------------------------------------------------------------------------------
-- INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('222.222.222-02', 'Marina Pietra Barros', '(83) 99314-1536');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('222.222.222-02', 'CAEST', '123', '222.222.222-02');

-------------------------------------------------------------------------------------------------------------------------
-- REFEITORIO
-------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.pessoa(cpf, nome, telefone) VALUES ('333.333.333-03', 'Giovana Bruna Duarte', '(83) 98559-2200');
INSERT INTO public.usuario(matricula, cargo, senha, pessoa_cpf)VALUES ('333.333.333-03', 'REFEITORIO', '123', '333.333.333-03');

-------------------------------------------------------------------------------------------------------------------------
-- EDITAL
-------------------------------------------------------------------------------------------------------------------------
-- Edital 01/2018
INSERT INTO public.edital(codigo, id, datasolicitacao, descricao, justificativa, statusrequisicao, periodo_codigo, usuario_matricula) VALUES ('01/2018', 1, '2018-02-01', 'Edital de Assistência Estudantil do IFPB', '', 'AUTORIZADA', '2018.1', '222.222.222-02');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (1, 1, '2018-02-01', '2019-02-01', 'AUTORIZADA', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (1, '20191210001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (1, '20191200001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (1, '20191230001');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (2, 1, '2018-02-01', '2018-07-08', 'AUTORIZADA', 2);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (2, '20191180001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (2, '201910490001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (2, '20191500001');
-- Edital 02/2018
INSERT INTO public.edital(codigo, id, datasolicitacao, descricao, justificativa, statusrequisicao, periodo_codigo, usuario_matricula) VALUES ('02/2018', 2, '2018-07-08', 'Edital de Assistência Estudantil do IFPB', '', 'AUTORIZADA', '2018.2', '222.222.222-02');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (3, 2, '2018-02-01', '2018-07-08', 'AUTORIZADA', 2);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (3, '20191180001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (3, '201910490001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (3, '20191500001');
-- Edital 01/2019
INSERT INTO public.edital(codigo, id, datasolicitacao, descricao, justificativa, statusrequisicao, periodo_codigo, usuario_matricula) VALUES ('01/2019', 3, '2019-02-01', 'Edital de Assistência Estudantil do IFPB', '', 'AUTORIZADA', '2019.1', '222.222.222-02');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (4, 3, '2018-02-01', '2019-02-01', 'AUTORIZADA', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (4, '20191210001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (4, '20191200001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (4, '20191230001');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (5, 3, '2018-02-01', '2018-07-08', 'AUTORIZADA', 2);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (5, '20191180001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (5, '201910490001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (5, '20191500001');
--Edital 02/2019
INSERT INTO public.edital(codigo, id, datasolicitacao, descricao, justificativa, statusrequisicao, periodo_codigo, usuario_matricula) VALUES ('02/2019', 4, '2019-07-08', 'Edital de Assistência Estudantil do IFPB', '', 'AUTORIZADA', '2019.2', '222.222.222-02');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (6, 4, '2018-02-01', '2018-07-08', 'AUTORIZADA', 2);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (6, '20191180001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (6, '201910490001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (6, '20191500001');

-------------------------------------------------------------------------------------------------------------------------
-- SOLICITACAO
-------------------------------------------------------------------------------------------------------------------------
--Autorizada
INSERT INTO public.solicitacao(id, datasolicitacao, descricao, justificativa, statusrequisicao, usuario_matricula) VALUES (5, '2019-02-01', 'Aula no contraturno do curso de Eng. Civil', '', 'AUTORIZADA', '5000001');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (7, 5, '2019-02-01', '2019-02-01', 'AUTORIZADA', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (7, '201912200001');
INSERT INTO public.autorizacao(id, data, hora, statusautorizacao, requisicao_id, aluno_matricula, refeicao_id) VALUES (1, '2019-02-01', '11:01:56', 'REALIZADA', 7, '201912200001', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (7, '201912200002');
INSERT INTO public.autorizacao(id, data, hora, statusautorizacao, requisicao_id, aluno_matricula, refeicao_id) VALUES (2, '2019-02-01', '11:32:12', 'REALIZADA', 7, '201912200002', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (7, '201912200003');
INSERT INTO public.autorizacao(id, data, hora, statusautorizacao, requisicao_id, aluno_matricula, refeicao_id) VALUES (3, '2019-02-01', '13:01:52', 'AUSENTE', 7, '201912200001', 1);
--Compulsoria
INSERT INTO public.solicitacao(id, datasolicitacao, descricao, justificativa, statusrequisicao, usuario_matricula) VALUES (6, '2019-06-01', 'Aula no contraturno do curso de ADS', '', 'COMPULSORIA', '5000002');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (8, 6, '2019-06-01', '2019-06-01', 'COMPULSORIA', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (8, '201912010001');
INSERT INTO public.autorizacao(id, data, hora, statusautorizacao, requisicao_id, aluno_matricula, refeicao_id) VALUES (4, '2019-06-01', '12:05:15', 'REALIZADA', 8, '201912010001', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (8, '201912010002');
INSERT INTO public.autorizacao(id, data, hora, statusautorizacao, requisicao_id, aluno_matricula, refeicao_id) VALUES (5, '2019-06-01', '12:07:07', 'REALIZADA', 8, '201912010002', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (8, '201912010003');
INSERT INTO public.autorizacao(id, data, hora, statusautorizacao, requisicao_id, aluno_matricula, refeicao_id) VALUES (6, '2019-06-01', '12:10:45', 'REALIZADA', 8, '201912010003', 1);
--Negada
INSERT INTO public.solicitacao(id, datasolicitacao, descricao, justificativa, statusrequisicao, usuario_matricula) VALUES (7, '2019-07-01', 'Aula no contraturno do curso de Esp. Matemática', 'Excede a quantidade limite de refeições.', 'NEGADA', '5000003');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (9, 7, '2019-07-01', '2019-07-01', 'NEGADA', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (9, '201912210001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (9, '201912210002');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (9, '201912210003');
--Pendente
INSERT INTO public.solicitacao(id, datasolicitacao, descricao, justificativa, statusrequisicao, usuario_matricula) VALUES (8, CURRENT_DATE, 'Aula no contraturno do curso de Eletromecânica Integrado', '', 'PENDENTE', '5000007');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (10, 8, CURRENT_DATE, CURRENT_DATE, 'PENDENTE', 1);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (10, '20191200001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (10, '20191200002');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (10, '20191200003');
INSERT INTO public.requisicao(id, solicitacao_id, datainicial, datafinal, statusrequisicao, refeicao_id) VALUES (11, 8, CURRENT_DATE, CURRENT_DATE, 'PENDENTE', 2);
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (11, '20191200001');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (11, '20191200002');
INSERT INTO public.requisicao_aluno(requisicao_id, alunos_matricula) VALUES (11, '20191200003');

--Sequence
INSERT INTO public.sequence(seq_name, seq_count) VALUES ('SEQ_GEN_TABLE', 100);

