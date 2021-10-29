TRUNCATE TABLE voto CASCADE; 
TRUNCATE TABLE eleitor CASCADE;
TRUNCATE TABLE candidato CASCADE;
TRUNCATE TABLE comissao_eleitoral CASCADE;
TRUNCATE TABLE comissao_pessoa CASCADE;
TRUNCATE TABLE cargo CASCADE;
TRUNCATE TABLE configuracao CASCADE;
TRUNCATE TABLE eleicao CASCADE;
TRUNCATE TABLE pessoa CASCADE;
TRUNCATE TABLE administrador CASCADE;


INSERT INTO pessoa (id, nome, cpf, data_nascimento, genero, endereco, email, telefone) VALUES (2, 'Carolina Paes de Lira Aleixo', 7053801497, '1988-06-19', 'F', 'R. Ulisses Cruz, 527, Tatuapé, São Paulo - SP', 'carolinalira19@gmail.com', '83996553541');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, genero, endereco, email, telefone) VALUES (1, 'Pedro Aleixo da Silva Neto', 4309557406, '1980-04-10', 'M', 'R. Ulisses Cruz, 527, Tatuapé, São Paulo - SP', 'pedro.aleixo@gmail.com', '11954609754');

INSERT INTO administrador (id, id_pessoa) VALUES (4, 1);

INSERT INTO eleicao (nome, instituicao, data_hora_inicio, data_hora_fim, situacao, id) VALUES ('nome', 'Home', '2021-10-13 21:31:44.942', '2021-10-14 21:31:44.942', 2, 4);
INSERT INTO eleicao (nome, instituicao, data_hora_inicio, data_hora_fim, situacao, id) VALUES ('nome', 'Home', '2021-10-13 21:31:44.942', '2021-10-14 21:31:44.942', 2, 5);
INSERT INTO eleicao (nome, instituicao, data_hora_inicio, data_hora_fim, situacao, id) VALUES ('nome', 'Home1', '2021-10-18 21:31:44.942', '2021-10-20 21:31:44.942', 5, 3);
INSERT INTO eleicao (nome, instituicao, data_hora_inicio, data_hora_fim, situacao, id) VALUES ('nome1', 'Home1', '2021-10-13 21:31:44.942', '2021-10-14 21:31:44.942', 5, 8);

INSERT INTO configuracao (id, id_eleicao, exibir_numeros_candidatos, exibir_consulta_eleitores_votantes, ordernar_por_numeros, existira_tempo_sessao, tempo_sessao) VALUES (1, 3, true, false, true, true, 13);

INSERT INTO cargo (id, nome, id_eleicao, votos_brancos) VALUES (1, 'Presidente', 3, 0);
INSERT INTO cargo (id, nome, id_eleicao, votos_brancos) VALUES (2, 'Conselheiro', 3, 0);

INSERT INTO comissao_eleitoral (id, nome, id_eleicao) VALUES (1, 'Comissão Teste', 3);

INSERT INTO comissao_pessoa (id, id_comissao, id_pessoa) VALUES (1, 1, 1);

INSERT INTO candidato (id, numero, votos, id_pessoa, id_cargo, id_eleicao) VALUES (6, 13, 127, 1, 1, 3);

INSERT INTO eleitor (id, id_pessoa, id_eleicao, data_hora_votou) VALUES (1, 2, 3, '2021-10-20 21:31:44.942');
INSERT INTO eleitor (id, id_pessoa, id_eleicao, data_hora_votou) VALUES (2, 1, 3, '2021-10-27 23:46:00.224');

INSERT INTO voto (voto_criptografado, id, id_eleicao) VALUES ('JB1o4tBzYmggxWKcFPGwqtZpWh+QQBpYdYbvccdQtDP3SoeFBLNKHqCeOcAHVmXRgKCZyKQ9Y7f25vRfS9L9Y29yAPMaVkBjLD5Ie41errQTc+a4+homxQAqpbIoYoXX75MZsxi4ArrrpTsLsdkrW2sUVn1Ao1bo6zJ7204I+zlcSsUv8qPe/C0vYVyXNabzJ6DECTEtz6ngAeksjw8G7yGqFPMQzD8+zxw/BKr1EhdpaKcTlDiUcquQ/hVxui8e1m345CmbmXYZoNcjvP6EdJAvLF6qGEu61LaZu0xvswsQVjDFcS+rnrbRVI/Tf52m6ktU2WGRsAldP6ljZIxVtA==', 1, 3);
INSERT INTO voto (voto_criptografado, id, id_eleicao) VALUES ('JB1o4tBzYmggxWKcFPGwqtZpWh+QQBpYdYbvccdQtDP3SoeFBLNKHqCeOcAHVmXRgKCZyKQ9Y7f25vRfS9L9Y29yAPMaVkBjLD5Ie41errQTc+a4+homxQAqpbIoYoXX75MZsxi4ArrrpTsLsdkrW2sUVn1Ao1bo6zJ7204I+zlcSsUv8qPe/C0vYVyXNabzJ6DECTEtz6ngAeksjw8G7yGqFPMQzD8+zxw/BKr1EhdpaKcTlDiUcquQ/hVxui8e1m345CmbmXYZoNcjvP6EdJAvLF6qGEu61LaZu0xvswsQVjDFcS+rnrbRVI/Tf52m6ktU2WGRsAldP6ljZIxVtA==', 2, 3);

