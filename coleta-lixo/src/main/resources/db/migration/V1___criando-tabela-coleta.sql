CREATE TABLE tbl_coleta_lixo(
    numero_lixeira INTEGER NOT NULL AUTO_INCREMENT,
    endereco VARCHAR(100) NOT NULL,
    data_coleta DATE NOT NULL,
    lixeira_cheia VARCHAR(3) NOT NULL,
    processo_coleta VARCHAR(3) NOT NULL,
    PRIMARY KEY (numero_lixeira)
);

--Agendamento automático de coleta com base na capacidade dos recipientes de lixo.
--
--Preencher dados como: endereço, data, recipiente_cheio, processo coleta
--
--(Sempre que atualizar o campo recipiente_cheio para sim, eu quero que um caminhoneiro que não esteja coletando lixo receba essa tarefa de ir coletar o lixo)