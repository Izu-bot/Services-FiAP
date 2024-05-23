package br.com.fiap.rastrearcaminhoes.dto;

import br.com.fiap.rastrearcaminhoes.model.ColetandoLixo;
import br.com.fiap.rastrearcaminhoes.model.RastrearCaminhoes;

import java.time.LocalDateTime;

public record ExibicaoDto(
        Long numeroCaminhao,
        String enderecoAtual,
        String nome,
        ColetandoLixo coletandoLixo,
        LocalDateTime dataHora
) {
    public ExibicaoDto(RastrearCaminhoes caminhoes){
        this(
          caminhoes.getNumeroCaminhao(),
          caminhoes.getEnderecoAtual(),
          caminhoes.getNome(),
          caminhoes.getColetandoLixo(),
          caminhoes.getDataHora()
        );
    }
}