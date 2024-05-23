CREATE TABLE tbl_rastrear(
    numero_caminhao INTEGER NOT NULL AUTO_INCREMENT,
    endereco_atual VARCHAR(100) NULL,
    nome VARCHAR(100) NOT NULL,
    coletando_lixo VARCHAR(3) NOT NULL,
    data_hora DATETIME NULL,
    PRIMARY KEY (numero_caminhao)
);


--endereço, data, hora, nome_caminhoneiro, coletando_lixo.