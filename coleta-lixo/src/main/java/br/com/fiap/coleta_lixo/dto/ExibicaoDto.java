package br.com.fiap.coleta_lixo.dto;

import br.com.fiap.coleta_lixo.model.ColetaLixo;
import br.com.fiap.coleta_lixo.model.Coletando;

import java.time.LocalDate;

public record ExibicaoDto(
        Long numeroLixeira,
        String endereco,
        LocalDate dataColeta,
        Coletando lixeiraCheia,
        Coletando processoColeta
) {
    public ExibicaoDto(ColetaLixo coletaLixo) {
        this(
                coletaLixo.getNumeroLixeira(),
                coletaLixo.getEndereco(),
                coletaLixo.getDataColeta(),
                coletaLixo.getLixeiraCheia(),
                coletaLixo.getProcessoColeta()
        );
    }
}
