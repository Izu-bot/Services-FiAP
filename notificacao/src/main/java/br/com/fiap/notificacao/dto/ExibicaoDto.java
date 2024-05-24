package br.com.fiap.notificacao.dto;

import br.com.fiap.notificacao.model.ColetaEnum;
import br.com.fiap.notificacao.model.Notificacao;

public record ExibicaoDto(
        Long id,
        String nome,
        String endereco,
        ColetaEnum diaColetaOrganica,
        ColetaEnum diaColetaPlastico
) {
    public ExibicaoDto(Notificacao notificacao){
        this(
          notificacao.getId(),
          notificacao.getNome(),
          notificacao.getEndereco(),
          notificacao.getDiaColetaOrganica(),
          notificacao.getDiaColetaPlastico()
        );
    }
}
