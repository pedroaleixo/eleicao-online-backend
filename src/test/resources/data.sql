INSERT INTO pessoa (id, nome, cpf, data_nascimento, genero, endereco, email, telefone) VALUES (pessoa_seq.nextval, 'Erick Thales Martins', 43983637779, '1986-01-24', 'M', 'Rua Eugênio Fassarella, 467, Centro, lto Castelino-ES', 'eerickthalesmartins@haldex.com', '28987658719');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, genero, endereco, email, telefone) VALUES (pessoa_seq.nextval, 'Patrícia Esther Luiza Moraes', 58658233880, '1993-05-08', 'F', 'Rua Pelotas, 826, Vila Mariana, São Paulo-SP', 'patriciaestherluizamoraes@soespodonto.com.br', '11983990115');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, genero, endereco, email, telefone) VALUES (pessoa_seq.nextval, 'Thomas Theo Monteiro', 37914072877, '1949-08-08', 'M', 'Quadra H, 737, Cidade Universitária, Parnaíba-PI', 'marcosnelsonarthurdacosta@publicarbrasil.com.br', '86989572909');

INSERT INTO administrador (id, id_pessoa) VALUES (administrador_seq.nextval, 1);
INSERT INTO administrador (id, id_pessoa) VALUES (administrador_seq.nextval, 2);

INSERT INTO eleicao (nome, instituicao, data_hora_inicio, data_hora_fim, situacao, id) VALUES ('Eleicao1', 'Instituicao1', '2021-10-13 21:31:44.942', '2021-10-14 21:31:44.942', 0, eleicao_seq.nextval);
INSERT INTO eleicao (nome, instituicao, data_hora_inicio, data_hora_fim, situacao, id) VALUES ('Eleicao2', 'Instituicao2', '2021-10-14 21:31:44.942', '2021-10-15 21:31:44.942', 1, eleicao_seq.nextval);
INSERT INTO eleicao (nome, instituicao, data_hora_inicio, data_hora_fim, situacao, id) VALUES ('Eleicao3', 'Instituicao3', '2021-10-15 21:31:44.942', '2021-10-16 21:31:44.942', 0, eleicao_seq.nextval);
INSERT INTO eleicao (nome, instituicao, data_hora_inicio, data_hora_fim, situacao, id) VALUES ('Eleicao4', 'Instituicao4', '2021-10-16 21:31:44.942', '2021-10-17 21:31:44.942', 5, eleicao_seq.nextval);

INSERT INTO configuracao (id, id_eleicao, exibir_numeros_candidatos, exibir_consulta_eleitores_votantes, ordernar_por_numeros, existira_tempo_sessao, tempo_sessao) VALUES (configuracao_seq.nextval, 3, true, false, true, true, 13);

INSERT INTO cargo (id, nome, id_eleicao, votos_brancos, escolhas) VALUES (cargo_seq.nextval, 'Presidente', 3, 0, 1);
INSERT INTO cargo (id, nome, id_eleicao, votos_brancos, escolhas) VALUES (cargo_seq.nextval, 'Conselheiro',3, 0, 5);

INSERT INTO comissao_eleitoral (id, id_eleicao) VALUES (comissao_eleitoral_seq.nextval, 3);

INSERT INTO comissao_pessoa (id_comissao, id_pessoa) VALUES (1, 1);

INSERT INTO candidato (id, numero, votos, id_pessoa, id_cargo, id_eleicao) VALUES (candidato_seq.nextval, 13, 127, 1, 1, 3);
INSERT INTO candidato (id, numero, votos, id_pessoa, id_cargo, id_eleicao) VALUES (candidato_seq.nextval, 13, 127, 2, 2, 3);

INSERT INTO eleitor (id, id_pessoa, id_eleicao, data_hora_votou) VALUES (eleitor_seq.nextval, 1, 3, '2021-10-20 21:31:44.942');
INSERT INTO eleitor (id, id_pessoa, id_eleicao, data_hora_votou) VALUES (eleitor_seq.nextval, 2, 3, '2021-10-27 23:46:00.224');
INSERT INTO eleitor (id, id_pessoa, id_eleicao, data_hora_votou) VALUES (eleitor_seq.nextval, 2, 1, '2021-10-27 23:46:00.224');

INSERT INTO voto (voto_criptografado, id, id_eleicao) VALUES ('JB1o4tBzYmggxWKcFPGwqtZpWh+QQBpYdYbvccdQtDP3SoeFBLNKHqCeOcAHVmXRgKCZyKQ9Y7f25vRfS9L9Y29yAPMaVkBjLD5Ie41errQTc+a4+homxQAqpbIoYoXX75MZsxi4ArrrpTsLsdkrW2sUVn1Ao1bo6zJ7204I+zlcSsUv8qPe/C0vYVyXNabzJ6DECTEtz6ngAeksjw8G7yGqFPMQzD8+zxw/BKr1EhdpaKcTlDiUcquQ/hVxui8e1m345CmbmXYZoNcjvP6EdJAvLF6qGEu61LaZu0xvswsQVjDFcS+rnrbRVI/Tf52m6ktU2WGRsAldP6ljZIxVtA==', voto_seq.nextval, 3);
INSERT INTO voto (voto_criptografado, id, id_eleicao) VALUES ('JB1o4tBzYmggxWKcFPGwqtZpWh+QQBpYdYbvccdQtDP3SoeFBLNKHqCeOcAHVmXRgKCZyKQ9Y7f25vRfS9L9Y29yAPMaVkBjLD5Ie41errQTc+a4+homxQAqpbIoYoXX75MZsxi4ArrrpTsLsdkrW2sUVn1Ao1bo6zJ7204I+zlcSsUv8qPe/C0vYVyXNabzJ6DECTEtz6ngAeksjw8G7yGqFPMQzD8+zxw/BKr1EhdpaKcTlDiUcquQ/hVxui8e1m345CmbmXYZoNcjvP6EdJAvLF6qGEu61LaZu0xvswsQVjDFcS+rnrbRVI/Tf52m6ktU2WGRsAldP6ljZIxVtA==', voto_seq.nextval, 3);

