CREATE TABLE tbl_coleta_lixo(
    numero_lixeira INTEGER NOT NULL AUTO_INCREMENT,
    endereco VARCHAR(100) NOT NULL,
    data_coleta DATE NOT NULL,
    lixeira_cheia VARCHAR(3) NOT NULL,
    processo_coleta VARCHAR(3) NOT NULL,
    PRIMARY KEY (numero_lixeira)
);
