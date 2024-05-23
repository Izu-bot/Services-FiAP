package br.com.fiap.rastrearcaminhoes.dto;

import br.com.fiap.rastrearcaminhoes.model.ColetandoLixo;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CadastroDto(

    Long numeroCaminhao,

    @NotBlank(message = "O endereço atual não pode estar vazio!")
    String enderecoAtual,

    @NotBlank(message = "O nome do caminhoneiro não pode estar vazio!")
    String nome,

    // Não tem como cadastrar vazio pois o preenchimento do campo e feito automatico
    ColetandoLixo coletandoLixo,
    LocalDateTime dataHora
) {
}
