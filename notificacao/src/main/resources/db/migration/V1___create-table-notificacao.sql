CREATE TABLE tbl_notificacao_morador(
    id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    dia_coleta_organico VARCHAR(3) NOT NULL,
    dia_coleta_plastico VARCHAR(3) NOT NULL,
    PRIMARY KEY (id)
);

--Preencher dados como: nome, endereço, dia_coleta, lixo_organico, lixo_plastico
